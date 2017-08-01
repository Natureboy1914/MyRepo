/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Location;
import com.sg.superhero.Dto.Sighting;
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
public class SightDaoImpl implements SightDao {
    
    private static final String SQL_INSERT_SIGHTING
            = "insert into Sighting (SightingDate, Sighting.LocationID) values(?,?) ";
    private static final String SQL_DELETE_SIGHTING
            = "delete from Sighting where SightingID = ? ";
    private static final String SQL_SELECT_SIGHTING
            = "select Sighting.*, Location.* "
            + "from Sighting"
            + " join Location on Location.LocationID = Sighting.LocationID "
            + "where Sighting.SightingID = ? ";
    private static final String SQL_SELECT_SIGHTING_BY_LOCATION
            = "select Sighting.*, Location.* "
            + "from Sighting"
            +" join Location on Location.LocationID = Sighting.LocationID "
            + "where Location.LocationID = ? ";
    private static final String SQL_UPDATE_SIGHTING
            = "update Sighting set SightingDate = ?, Sighting.LocationID = ? where SightingID = ? ";
    private static final String SQL_SELECT_ALL_SIGHTING
           = "select Sighting.*, Location.* "
            + "from Sighting"
            + " join Location on Location.LocationID = Sighting.LocationID ";
              
    
    private static final String SQL_SELECT_SIGHTING_BY_DATE
            ="select Sighting.*, Location.* "
            + "from Sighting"
            + " join Location on Location.LocationID = Sighting.LocationID where SightingDate = ? ";
    
    private static final String SQL_SELECT_SIGHTING_BY_HERO
            ="select Sighting.*, Location.* "
            +"from Sighting "
            +"join SuperHeroSighting on SuperHeroSighting.SuperHeroID = SuperHero.SuperHeroID "
            +"and SuperHero.SuperHeroID = ? ";
    
    
     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sight) {
         jdbcTemplate.update(SQL_INSERT_SIGHTING,
               sight.getDate(),
               sight.getLocation().getLocationID());

        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        sight.setSightingID(newId);

        return sight;
    }

    @Override
    public List<Sighting> allSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTING,
                new SightingMapper());
    }

    @Override
    public void updateSighting(Sighting sight) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sight.getDate(),
                sight.getLocation().getLocationID(),
                sight.getSightingID());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeSighting(int sightingId) {
         jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
         jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public Sighting getSighting(int sightingId) {
         Sighting sight = new Sighting();

        try {

            sight = jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING,
                    new SightingMapper(), sightingId);
            
//         
            return sight;
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just 
            // want to return null in this case
            return null;
        }
    }
    

    public void SightingByLocation(Sighting sight){
        
            jdbcTemplate.query(SQL_SELECT_SIGHTING_BY_LOCATION,
                        new SightingMapper(),
                        sight.getSightingID());
        
    }
    
    public void SightingByDate(Sighting sight){
        
              jdbcTemplate.query(SQL_SELECT_SIGHTING_BY_DATE,
                            new SightingMapper(),
                            sight.getSightingID());
            
        
    }
    
    public void SightingByHero(Sighting sight){
                      jdbcTemplate.query(SQL_SELECT_SIGHTING_BY_HERO,

                            new SightingMapper(),
                            sight.getSightingID());
    }
    
     private static final class SightingMapper implements RowMapper<Sighting> {
        public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sighting sight = new Sighting();
            Location loc = new Location();
            loc.setLocationID(rs.getInt("LocationID"));
            loc.setName(rs.getString("LocationName"));
            loc.setDescription(rs.getString("Description"));
            loc.setAddress(rs.getString("Address"));
            loc.setLatitude(rs.getDouble("Latitude"));
            loc.setLongitude(rs.getDouble("Longitude"));
            sight.setDate(rs.getDate("SightingDate"));
            sight.setLocation(loc);
            
            return sight;
        }
    }

}
