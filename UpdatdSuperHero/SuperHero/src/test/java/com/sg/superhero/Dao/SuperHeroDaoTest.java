/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Organization;
import com.sg.superhero.Dto.SuperHero;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class SuperHeroDaoTest {

    SuperHeroDao dao;
    OrgDao gdao;

    public SuperHeroDaoTest() {

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

        dao = ctx.getBean("SuperHeroDao", SuperHeroDao.class);
        gdao = ctx.getBean("OrgDao", OrgDao.class);

        List<SuperHero> hero = dao.allHeros();
        for (SuperHero SH : hero) {

            dao.removeHero(SH.getSuperHeroID());
        }

        List<Organization> orgs = gdao.allOrg();
        for (Organization o : orgs) {

            gdao.removeOrganization(o.getOrgID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addHero method, of class SuperHeroDao.
     */
    @Test
    public void testGetAddHero() {
        SuperHero hero = new SuperHero();
        Organization org1 = new Organization();

        List<Organization> theOrgs = new ArrayList<>();

        org1.setName("A.U. Acadamy");
        org1.setDescription(" hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

        gdao.addOrg(org1);
        theOrgs.add(org1);

        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrgs);
        hero.setSuperPower("Super strenght");

        dao.addHero(hero);

        SuperHero fromDao = dao.getHero(hero.getSuperHeroID());

        assertEquals(fromDao, hero);

    }

    @Test
    public void testgetAllHero() {

        SuperHero hero = new SuperHero();
        SuperHero hero1 = new SuperHero();
        Organization org1 = new Organization();

        Organization org2 = new Organization();

        List<Organization> theOrg = gdao.allOrg();

        List<SuperHero> listOfHeros = new ArrayList<>();

        org1.setName("A.U. Acadamy");
        org1.setDescription(" hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

        org2.setName("Elite Acadamy");
        org2.setDescription(" hero elite");
        org2.setAddress("1000North metro ave");
        org2.setEmail("eliteacadamy@gmail.com");

        gdao.addOrg(org1);
        gdao.addOrg(org2);
        theOrg.add(org1);
        theOrg.add(org2);

        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrg);
        hero.setSuperPower("Super strenght");

        hero1.setName("Goku");
        hero1.setDescription("DBZ Savior");
        hero1.setOrgs(theOrg);
        hero1.setSuperPower("lazer beam");

        dao.addHero(hero);
        dao.addHero(hero1);

        listOfHeros.add(hero);
        listOfHeros.add(hero1);

        assertEquals(2, dao.allHeros().size());
    }

    /**
     * Test of updateHero method, of class SuperHeroDao.
     */
    @Test
    public void testUpdateHero() {
        SuperHero hero = new SuperHero();
        Organization org1 = new Organization();

        List<Organization> theOrg = new ArrayList<>();

        org1.setName("A.U. Acadamy");
        org1.setDescription(" hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

        gdao.addOrg(org1);
        theOrg.add(org1);

        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrg);
        hero.setSuperPower("Super strenght");

        dao.addHero(hero);

        hero.setName("Zoom");
        dao.updateHero(hero);
        SuperHero fromDao = dao.getHero(hero.getSuperHeroID());
        assertEquals(fromDao, hero);

    }

    /**
     * Test of removeHero method, of class SuperHeroDao.
     */
    @Test
    public void testRemoveHero() {
        SuperHero hero = new SuperHero();
        Organization org1 = new Organization();

        List<Organization> theOrg = new ArrayList<>();

        org1.setName("A.U. Acadamy");
        org1.setDescription(" hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

        gdao.addOrg(org1);
        theOrg.add(org1);

        hero.setName("All Might");
        hero.setDescription("Fights crime with a smile");
        hero.setOrgs(theOrg);
        hero.setSuperPower("Super strenght");

        dao.addHero(hero);
        SuperHero fromDao = dao.getHero(hero.getSuperHeroID());
        assertEquals(fromDao, hero);
        dao.removeHero(hero.getSuperHeroID());
        assertNull(dao.getHero(hero.getSuperHeroID()));
    }

}
