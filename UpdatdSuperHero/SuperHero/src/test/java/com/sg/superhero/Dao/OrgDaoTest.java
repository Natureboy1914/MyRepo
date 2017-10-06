/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Organization;
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
public class OrgDaoTest {
    
    OrgDao gdao;
    
    public OrgDaoTest() {
        
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
     * Test of addOrg method, of class OrgDao.
     */
    @Test
    public void testAddOrg() {
        Organization org1 = new Organization();
          
        org1.setName("A.U. Acadamy");
        org1.setDescription("hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");
      
        gdao.addOrg(org1);
        Organization fromDao = gdao.getOrganization(org1.getOrgID());
        assertEquals(fromDao.getName(), "A.U. Acadamy");
        assertEquals(fromDao.getAddress(), "2525 North metro ave");
        
        
    }

    /**
     * Test of allOrg method, of class OrgDao.
     */
    @Test
    public void testAllOrg() {
        
        Organization org1 = new Organization();
        Organization org2 = new Organization();
        
        List<Organization> orglist = new ArrayList<>();
        
        
        org1.setName("A.U. Acadamy");
        org1.setDescription("hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

         org2.setName("E.U. Acadamy");
        org2.setDescription("sideKick headquaters");
        org2.setAddress("2500 south metro ave");
        org2.setEmail("euacadamy@gmail.com");
         gdao.addOrg(org1);
         gdao.addOrg(org2);
        
      
        orglist.add(org1);
        orglist.add(org2);
       
     
        assertEquals("E.U. Acadamy", orglist.get(1).getName());
        assertEquals(gdao.allOrg().get(0).getName(),orglist.get(0).getName() );
       
      
    }

    /**
     * Test of updateOrganization method, of class OrgDao.
     */
    @Test
    public void testUpdateOrganization() {
        Organization org1 = new Organization();
  
        org1.setName("A.U. Acadamy");
        org1.setDescription("hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");

        gdao.addOrg(org1);
        org1.setName("E.U. Acadamy");
        gdao.updateOrganization(org1);
        
        
        Organization fromDao = gdao.getOrganization(org1.getOrgID());
        assertEquals(fromDao.getName(), "A.U. Acadamy");
                
    }

    /**
     * Test of removeOrganization method, of class OrgDao.
     */
    @Test
    public void testRemoveOrganization() {
        Organization org1 = new Organization();
          
        org1.setName("A.U. Acadamy");
        org1.setDescription("hero headquaters");
        org1.setAddress("2525 North metro ave");
        org1.setEmail("auacadamy@gmail.com");
      
        gdao.addOrg(org1);
        
        Organization fromDao = gdao.getOrganization(org1.getOrgID());
        assertEquals(fromDao.getName(), "A.U. Acadamy");
        
        gdao.removeOrganization(org1.getOrgID());
        assertNull(gdao.getOrganization(org1.getOrgID()));
                
    }
  
}
