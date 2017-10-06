/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;


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
public class OrgDaoImpl implements OrgDao {
    
    private static final String SQL_INSERT_ORGANIZATION
            = "insert into Organization "
            + "(OrganizationName, Description, Address, Email ) "
            + "values (?, ?, ?, ?) ";
    
    private static final String SQL_DELETE_ORGANIZATION
            = "delete from Organization where OrganizationID = ? ";
    
   public static final String SQL_DELETE_ORGANIZATION_BY_SUPERHERO
           ="delete from MemberOrg where OrganizationID = ? ";
           
    private static final String SQL_SELECT_ORGANIZATION
            = "select * from Organization where OrganizationID = ? ";
    
    private static final String SQL_UPDATE_ORGANIZATION
            = "update Organization set "
            + "OrganizationName = ?, "
            + "Description = ?, "
            + "Address = ?, "
            + "Email = ? "
            + "where OrganizationID = ? ";
    
    private static final String SQL_SELECT_ALL_ORGANIZATION
             = "select * from Organization ";
    
     private static final String SQL_SELECT_ORGANIZATION_BY_SUPERHERO
             = "select from Organization.*  "
             +" join MemberOrg on MemberOrg.OrganizationID = Organization.OrganizationID "
             +" join SuperHero on SuperHero.OrganizationID = MemberOrg.OrganizationID "
             + " and SuperHero.OrganizationID = ? ";
    
    
     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Organization addOrg(Organization Org) {
       jdbcTemplate.update(SQL_INSERT_ORGANIZATION, 
                   Org.getName(),
                   Org.getDescription(),
                   Org.getAddress(),
                   Org.getEmail());
                int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                                            Integer.class);
    // set the new id value on the contact object and return it
    Org.setOrgID(newId);

    
    return Org;
    }

    @Override
    public List<Organization> allOrg() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATION, 
                              new OrganizationMapper()); 
    }

    @Override
    public void updateOrganization(Organization org) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                
                org.getOrgID(),
                org.getName(),
                org.getDescription(),
                org.getAddress(),
                org.getEmail());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeOrganization(int OrganizationId) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, OrganizationId);
         jdbcTemplate.update(SQL_DELETE_ORGANIZATION_BY_SUPERHERO, OrganizationId);
    }

    @Override
    public Organization getOrganization(int OrganizationId) {
         try {
      
        return  jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION,
                new OrganizationMapper(), OrganizationId);
    } catch (EmptyResultDataAccessException ex) {
        // there were no results for the given contact id - we just 
        // want to return null in this case
        return null;
    
    }
    
    }
    
    public void getOrganizationByHero(Organization org){
        jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BY_SUPERHERO,
                     new OrganizationMapper(), org.getOrgID() );
    }
    
     private static final class OrganizationMapper implements RowMapper<Organization> {

        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization org = new Organization();
            org.setOrgID(rs.getInt("OrganizationID"));
            org.setName(rs.getString("OrganizationName"));
            org.setDescription(rs.getString("Description"));
            org.setAddress(rs.getString("Address"));
            org.setEmail(rs.getString("Email"));
            
            return org;
        }
    }

    
}
