/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Location;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class LocationDaoTest {
    
    LocationDao ldao;
    
    public LocationDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
                 = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        ldao = ctx.getBean("LocationDao", LocationDao.class);
                
                List<Location> loc = ldao.allLocations();
                for(Location l: loc){
                    ldao.removeLocation(l.getLocationID());
                } 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLocation method, of class LocationDao.
     */
    @Test
    public void testAddLocation() {
        Location loc = new Location();
        
        
        loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        ldao.addLocation(loc);
        
        Location fromDao = ldao.getLocation(loc.getLocationID());
        assertEquals(fromDao.getName(), loc.getName());
        
    }

    /**
     * Test of allLocations method, of class LocationDao.
     */
    @Test
    public void testAllLocations() {
        Location loc = new Location();
        
        List<Location> locList = new ArrayList();
        
        
        loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        ldao.addLocation(loc);
        locList.add(loc);
        
        
        assertEquals(locList.get(0).getName(), ldao.allLocations().get(0).getName());
        assertEquals(ldao.allLocations().get(0).getName(), "Park");
    }

    /**
     * Test of updateLocation method, of class LocationDao.
     */
    @Test
    public void testUpdateLocation() {
        
         Location loc = new Location();
        
        
        loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        ldao.addLocation(loc);
        loc.setName("School");
        ldao.updateLocation(loc);
        
        Location fromDao = ldao.getLocation(loc.getLocationID());
        assertEquals(fromDao.getName(), "School");
        
    }

    /**
     * Test of removeLocation method, of class LocationDao.
     */
    @Test
    public void testRemoveLocation() {
         Location loc = new Location();
        
        
        loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        ldao.addLocation(loc);
        Location fromDao = ldao.getLocation(loc.getLocationID());
        assertEquals(fromDao.getName(), "Park");
        ldao.removeLocation(loc.getLocationID());
        assertNull(ldao.getLocation(loc.getLocationID()));
        
        
    }

    
}
