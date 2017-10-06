/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Location;
import com.sg.superhero.Dto.Organization;
import com.sg.superhero.Dto.Sighting;
import com.sg.superhero.Dto.SuperHero;
import java.util.ArrayList;
import java.sql.Date;
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
public class SightDaoTest {

    SightDao sdao;
    LocationDao ldao;
    SuperHeroDao dao;
    OrgDao gdao;

    public SightDaoTest() {
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

        sdao = ctx.getBean("SightDao", SightDao.class);
        ldao = ctx.getBean("LocationDao", LocationDao.class);
        dao = ctx.getBean("SuperHeroDao", SuperHeroDao.class);

        List<Sighting> sight = sdao.allSightings();
        for (Sighting SH : sight) {

            sdao.removeSighting(SH.getSightingID());
        }

        List<Location> loc = ldao.allLocations();
        for (Location l : loc) {
            ldao.removeLocation(l.getLocationID());
        }

        List<SuperHero> hero = dao.allHeros();
        for (SuperHero SH : hero) {

            dao.removeHero(SH.getSuperHeroID());
        }
        
            gdao = ctx.getBean("OrgDao", OrgDao.class);
                
                List<Organization> Orgs = gdao.allOrg();
                for(Organization o: Orgs){
                    gdao.removeOrganization(o.getOrgID());
                }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addHero method, of class SightDao.
     */
    @Test
    public void testAddSight() {
        Sighting sight1 = new Sighting();
       
        SuperHero hero = new SuperHero();
        Location loc = new Location();
        Organization orgs = new Organization();
        
        orgs.setName("A.U. Acadamy");
        orgs.setDescription("hero headquaters");
        orgs.setAddress("2525 North metro ave");
        orgs.setEmail("auacadamy@gmail.com");
      
        List<Organization> theOrgs = gdao.allOrg();
        List<SuperHero> heroList = dao.allHeros();
        
        theOrgs.add(orgs);
        heroList.add(hero);
        
         loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        
        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrgs);
        hero.setSuperPower("Super strenght");
        
        
        gdao.addOrg(orgs);
        dao.addHero(hero);
        
        ldao.addLocation(loc);

        sight1.setDate( Date.valueOf("2017-02-20"));
        sight1.setLocation(loc);
        sight1.setHeros(heroList);

        sdao.addSighting(sight1);
   
        Sighting fromDao = sdao.getSighting(sight1.getSightingID());
        assertEquals(fromDao.getDate(),  Date.valueOf("2017-02-20"));
   

    }

    /**
     * Test of allSightings method, of class SightDao.
     */
    @Test
    public void testAllSightings() {
         Sighting sight1 = new Sighting();
         Sighting sight2 = new Sighting();
        SuperHero hero = new SuperHero();
        Location loc = new Location();
        Organization orgs = new Organization();

       
          
        orgs.setName("A.U. Acadamy");
        orgs.setDescription("hero headquaters");
        orgs.setAddress("2525 North metro ave");
        orgs.setEmail("auacadamy@gmail.com");
      
        List<Organization> theOrgs = gdao.allOrg();
        List<SuperHero> heroList = dao.allHeros();
        
        theOrgs.add(orgs);
        heroList.add(hero);
        
         loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        
        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrgs);
        hero.setSuperPower("Super strenght");
        
        
        gdao.addOrg(orgs);
        dao.addHero(hero);
        
        ldao.addLocation(loc);

        List<Sighting> sightList = new ArrayList<>();

        heroList.add(hero);

        sight1.setDate (Date.valueOf("2017-02-20"));
        sight1.setLocation(loc);
        sight1.setHeros(heroList);

        sight2.setDate( Date.valueOf("2017-02-20"));
        sight2.setLocation(loc);
        sight2.setHeros(heroList);

        sdao.addSighting(sight1);
        sdao.addSighting(sight2);

        sightList.add(sight1);
        sightList.add(sight2);

       
        assertEquals(sightList.get(0).getDate(), sdao.allSightings().get(0).getDate());
        assertEquals(sdao.allSightings().get(0).getDate(),  Date.valueOf("2017-02-20"));

    }

    /**
     * Test of updateSighting method, of class SightDao.
     */
    @Test
    public void testUpdateSighting() {
      Sighting sight1 = new Sighting();
        SuperHero hero = new SuperHero();
        Location loc = new Location();
        Organization orgs = new Organization();
                
        orgs.setName("A.U. Acadamy");
        orgs.setDescription("hero headquaters");
        orgs.setAddress("2525 North metro ave");
        orgs.setEmail("auacadamy@gmail.com");
      
        List<Organization> theOrgs = gdao.allOrg();
        List<SuperHero> heroList = dao.allHeros();
        
        theOrgs.add(orgs);
        heroList.add(hero);
        
         loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        
        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrgs);
        hero.setSuperPower("Super strenght");
        
        
        gdao.addOrg(orgs);
        dao.addHero(hero);
        
        ldao.addLocation(loc);

        sight1.setDate( Date.valueOf("2017-02-20"));
        sight1.setLocation(loc);
        sight1.setHeros(heroList);

        sdao.addSighting(sight1);
        sight1.setDate( Date.valueOf("2017-06-20"));
        sdao.updateSighting(sight1);

        Sighting fromDao = sdao.getSighting(sight1.getSightingID());
        assertEquals(fromDao.getDate(),   Date.valueOf("2017-06-20"));

    }

    /**
     * Test of removeSighting method, of class SightDao.
     */
    @Test
    public void testRemoveSighting() {
       Sighting sight1 = new Sighting();
        SuperHero hero = new SuperHero();
        Location loc = new Location();
        Organization orgs = new Organization();

      
        orgs.setName("A.U. Acadamy");
        orgs.setDescription("hero headquaters");
        orgs.setAddress("2525 North metro ave");
        orgs.setEmail("auacadamy@gmail.com");
      
        List<Organization> theOrgs = gdao.allOrg();
        List<SuperHero> heroList = dao.allHeros();
        
        theOrgs.add(orgs);
        heroList.add(hero);
        
         loc.setName("Park");
        loc.setDescription("open community area");
        loc.setAddress("234 oak ridge");
        loc.setLatitude(new Double("10.0"));
        loc.setLongitude(new Double("15.60"));
        
        
        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrgs);
        hero.setSuperPower("Super strenght");
        
        
        gdao.addOrg(orgs);
        dao.addHero(hero);
        
        ldao.addLocation(loc);

        sight1.setDate( Date.valueOf("2017-02-20"));
        sight1.setLocation(loc);
        sight1.setHeros(heroList);

        sdao.addSighting(sight1);
        Sighting fromDao = sdao.getSighting(sight1.getSightingID());
        assertEquals(fromDao.getDate(), Date.valueOf("2017-02-20"));
        sdao.removeSighting(sight1.getSightingID());
        assertNull(sdao.getSighting(sight1.getSightingID()));
    }

    /**
     * Test of getSighting method, of class SightDao.
     */
}
