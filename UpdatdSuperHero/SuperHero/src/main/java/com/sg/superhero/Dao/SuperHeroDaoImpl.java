/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Location;
import com.sg.superhero.Dto.Organization;
import com.sg.superhero.Dto.SuperHero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SuperHeroDaoImpl implements SuperHeroDao {

    OrgDao gdao;

    public SuperHeroDaoImpl(OrgDao gdao) {
        this.gdao = gdao;
    }

    private static final String SQL_INSERT_SUPERHERO
            = "insert into SuperHero(SuperHeroName, Description, SuperPower) values (?, ?, ?) ";

    private static final String SQL_DELETE_SUPERHERO
            = "delete from SuperHero where SuperHeroID = ? ";
    private static final String SQL_DELETE_SUPERHERO_BY_LOCATION
            = "delete from SuperHeroSighting where SuperHeroID = ? ";
    private static final String SQL_DELETE_SUPERHERO_BY_SIGHTING
             = "delete from SuperHeroSighting where SuperHeroSighting.SightingID = ? ";
    private static final String SQL_INSERT_MEMBER_ORG
            = "insert into MemberOrg (SuperHeroID, OrganizationID) value(?,?) ";

    private static final String SQL_DELETE_SUPERHEROS_BY_ORGANIZATION
            = "delete from MemberOrg where SuperHeroID = ? ";
    private static final String SQL_SELECT_SUPERHERO
            = "select * from SuperHero where SuperHeroID = ? ";
    private static final String SQL_UPDATE_SUPERHERO
            = "update SuperHero set SuperHeroName = ?, Description = ?, SuperPower = ? where SuperHeroID = ? ";
    
    private static final String SQL_SELECT_ALL_SUPERHERO
            = "select * from SuperHero";

    private static final String SQL_SELECT_SUPERHERO_BY_LOCATION
            = "select SuperHero.* "
            + "from SuperHero "
            + "join SuperHeroSighting on SuperHeroSighting.SuperHeroID = SuperHero.SuperHeroID "
            + "join Sighting on Sighting.SightingID = SuperHeroSighting.SightingID "
            + "join Location on Location.LocationID = Sighting.LocationID "
            + "and Location.LocationID = ? ";

    private static final String SQL_SELECT_SUPERHEROS_BY_ORGANIZATION
            = "select SuperHero.* "
            + "from SuperHero "
            + "join MemberOrg on MemberOrg.SuperHeroID = SuperHero.SuperHeroID "
            + "join Organization on Organization.OrganizationID = MemberOrg.OrganizationID "
            + "and Organization.OrganizationID = ? ";

    private static final String SQL_SELECT_ORGANIZATION_BYSUPERHERO
            = "select Organization.* "
            + "from Organization "
            + "join MemberOrg on MemberOrg.OrganizationID = Organization.OrganizationID "
            + "join SuperHero on SuperHero.SuperHeroID = MemberOrg.SuperHeroID "
            + "and SuperHero.SuperHeroID = ? ";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SuperHero addHero(SuperHero supH) {
      
        
        jdbcTemplate.update(SQL_INSERT_SUPERHERO,
                supH.getName(),
                supH.getDescription(),
                supH.getSuperPower());

        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        supH.setSuperHeroID(newId);

        return supH;

}

    @Override
    public List<SuperHero> allHeros() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERHERO,
                new SuperHeroMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateHero(SuperHero supH) {
        jdbcTemplate.update(SQL_UPDATE_SUPERHERO,
                supH.getName(),
                supH.getDescription(),
                supH.getSuperPower(),
               supH.getSuperHeroID());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeHero(int heroId) {
        
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_BY_LOCATION, heroId);
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_BY_SIGHTING, heroId);
        jdbcTemplate.update(SQL_DELETE_SUPERHEROS_BY_ORGANIZATION, heroId);
        jdbcTemplate.update(SQL_DELETE_SUPERHERO, heroId);
    }

    @Override
    public SuperHero getHero(int heroId) {
        SuperHero hero = new SuperHero();

        try {

            hero = jdbcTemplate.queryForObject(SQL_SELECT_SUPERHERO,
                    new SuperHeroMapper(), heroId);
//            hero.setOrgs(OrgBySh(hero));
            return hero;
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just 
            // want to return null in this case
            return null;
        }
    }

    public void supHeroOrg(SuperHero heros) {
        final int superHeroId = heros.getSuperHeroID();
        final List<Organization> orgs = heros.getOrgs();

        for (Organization o : orgs) {
            jdbcTemplate.update(SQL_INSERT_MEMBER_ORG,
                    superHeroId,
                    o.getOrgID());
        }

    }

    public List<SuperHero> heroAtLoca(Location loc) {

        return jdbcTemplate.query(SQL_SELECT_SUPERHERO_BY_LOCATION,
                new SuperHeroMapper(),
                loc.getLocationID());
    }

    public List<SuperHero> herosAtOrg(Organization org) {
        return jdbcTemplate.query(SQL_SELECT_SUPERHEROS_BY_ORGANIZATION,
                new SuperHeroMapper(),
                org.getOrgID());
    }

    public List<Organization> OrgBySh(SuperHero hero) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BYSUPERHERO,
                new OrganizationMapper(),
                hero.getSuperHeroID());
    }

    private static final class SuperHeroMapper implements RowMapper<SuperHero> {

        public SuperHero mapRow(ResultSet rs, int rowNum) throws SQLException {
            SuperHero hero = new SuperHero();

            hero.setSuperHeroID(rs.getInt("SuperHeroID"));
            hero.setName(rs.getString("SuperHeroName"));
            hero.setDescription(rs.getString("Description"));
            hero.setSuperPower(rs.getString("SuperPower"));
            return hero;
        }
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization org = new Organization();
            org.setOrgID(rs.getInt("SuperHeroID"));
            org.setName(rs.getString("OrganizationName"));
            org.setDescription(rs.getString("Description"));
            org.setAddress(rs.getString("Address"));
            org.setEmail(rs.getString("Email"));
            return org;
        }
    }
}
