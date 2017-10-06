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
public class LocationDaoImpl implements LocationDao {
    
    private static final String SQL_INSERT_LOCATION
            = "insert into Location (LocationName, Description, Address, Latitude, Longitude) values (?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE_LOCATION
            = "delete from Location where LocationID = ? ";
    private static final String SQL_DELETE_SIGHTINGLOCATION
            = "delete from Sighting where LocationID = ? ";
    private static final String SQL_SELECT_LOCATION
            = "select * from Location where LocationID = ? ";
    private static final String SQL_UPDATE_LOCATION
            = "update Location set LocationName = ?, Description = ?, Address = ?, Latitude = ?, Longitude = ? where locationID = ? ";
    private static final String SQL_SELECT_ALL_LOCATION
             = "select * from Location ";
    
    private static final String SQL_SELECT_LOCATION_BY_SIGHTING
             = "select Location.* "
               +"from Location "
               +"join Sighting on Sighting.LocationID = Location.LocationID "
               +"and Sighting.LocationID = ? ";
    
    
     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Location addLocation(Location loc) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                loc.getName(),
                loc.getDescription(),
                loc.getAddress(),
                loc.getLatitude(),
                loc.getLongitude());

        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        loc.setLocationID(newId);

        return loc;
    }

    @Override
    public List<Location> allLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATION,
                new LocationMapper());
    }

    @Override
    public void updateLocation(Location loc) {
            jdbcTemplate.update(SQL_UPDATE_LOCATION,
                loc.getName(),
                loc.getDescription(),
                loc.getAddress(),
                loc.getLatitude(),
                loc.getLongitude(),
                loc.getLocationID());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeLocation(int LocationId) {
         jdbcTemplate.update(SQL_DELETE_SIGHTINGLOCATION, LocationId);
        jdbcTemplate.update(SQL_DELETE_LOCATION, LocationId);
       
        
    }

    @Override
    public Location getLocation(int LocationId) {
        Location loc = new Location();

        try {

            loc = jdbcTemplate.queryForObject(SQL_SELECT_LOCATION,
                    new LocationMapper(), LocationId);
            
            return loc;
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just 
            // want to return null in this case
            return null;
        }
    }
    
    public List<Location> locBySight(Sighting sight){
        return jdbcTemplate.query(SQL_SELECT_LOCATION_BY_SIGHTING,
                    new LocationMapper(),
                    sight.getSightingID());
        
    }
    
     private static final class LocationMapper implements RowMapper<Location> {

        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("LocationID"));
            location.setName(rs.getString("LocationName"));
            location.setDescription(rs.getString("Description"));
            location.setAddress(rs.getString("Address"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));

            return location;
        }
    }

    
}
