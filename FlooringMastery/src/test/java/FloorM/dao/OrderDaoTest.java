/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Orders;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class OrderDaoTest {
    String date;
    private OrderDao dao = new OrderDaoImpl(date);
    
    public OrderDaoTest() {
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
     * Test of displasyOrder method, of class OrderDao.
     */
    @Test
    public void testDisplasyOrder() {
        
      
    }

   

    /**
     * Test of loadOrders method, of class OrderDao.
     */
    @Test
    public void testLoadOrders() throws Exception {
        Orders ord = new Orders();
        
         ord.setDate("03032017");
         
          date = ord.getDate();
        
        try{
            
           dao.loadOrders(date);
        }catch(FileNotFoundException e){
            fail("There is no such file ");
        }
    }
}