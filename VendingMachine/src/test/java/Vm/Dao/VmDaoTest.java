/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import Vm.Dto.VItems;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Olayinka
 */
public class VmDaoTest {

    private VmDao dao = new VmDaoFileImpl();

    public VmDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of vItems method, of class VmDao.
     */
    @Test
    public void testVItems() {
        
    }

    /**
     * Test of getAllItem method, of class VmDao.
     */
    @Test
    public void testGetAllItem() {
        int count = dao.vItems().size();

        assertEquals(8, count);

    }

    @Test
    public void testUpdateItems() {
        int myInventory = 0;
        int newInventory = 0;
        
        List<VItems> vItems = dao.vItems();
        for (VItems v : vItems) {
            if ("BeefSticks".equals(v.getName())) {
                myInventory = v.getInventory();
            }

        }
        dao.updateItems("BeefSticks");
        
        
        for (VItems v : vItems) {
            if ("BeefSticks".equals(v.getName())) {
                newInventory = v.getInventory();
            }

        }

        assertEquals( myInventory - 1,newInventory );

    }

}
