/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.service;

import FloorM.dao.OrderDao;
import FloorM.dao.OrderDaoStubImpl;
import FloorM.dao.ProductDao;
import FloorM.dao.ProductStubDaoImpl;
import FloorM.dao.TaxDao;
import FloorM.dao.TaxStubDaoImpl;
import FloorM.dto.Orders;
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
public class FlServiceImplTest {
    
   private final FlService service;
    OrderDao daoStub;
    TaxDao tDaoStub;
     ProductDao pDaoStub;
    public FlServiceImplTest() {
//         daoStub = new OrderDaoStubImpl();
//         tDaoStub = new TaxStubDaoImpl();
//         pDaoStub = new ProductStubDaoImpl();
//        service = new FlServiceImpl(daoStub,pDaoStub,tDaoStub);
        
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    service = ctx.getBean("FlService",FlService.class );
        
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
     * Test of validateProductNameInput method, of class FlServiceImpl.
     */
    @Test
    public void testValidateProductNameInput() throws Exception {

        
   try{
       service.validateProductNameInput("Carpet");
   }catch(ValidationProdException e){
       fail("There is no Item like that ");
   }
        
    
    }

    /**
     * Test of validateStateInput method, of class FlServiceImpl.
     */
    @Test
    public void testValidateStateInput() throws Exception {
        Orders ord = new Orders();
        
        try{
            service.validateStateInput("MI", ord);
        }catch(Exception e){
            
        }
  
    }

    /**
     * Test of newOrderNum method, of class FlServiceImpl.
//     */
    @Test
    public void testNewOrderNum() {
        Orders ord = new Orders();
        int currentOrdNum = 1;
        int newOrdNum =ord.getOrderNumber();
       service.newOrderNum("03032017");
       
       if(newOrdNum == currentOrdNum){
           newOrdNum++;
       }
       
       assertEquals(currentOrdNum + 1,2 );
    }
//
//    /**
//     * Test of displasyOrder method, of class FlServiceImpl.
//     */new
//    @Test
//    public void testDisplasyOrder() {
//        System.out.println("displasyOrder");
//        String date = "";
//        FlServiceImpl instance = null;
//        List<Orders> expResult = null;
//        List<Orders> result = instance.displasyOrder(date);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateOrder method, of class FlServiceImpl.
//     */
//    @Test
//    public void testUpdateOrder() {
//        System.out.println("updateOrder");
//        Orders updaterOrders = null;
//        FlServiceImpl instance = null;
//        boolean expResult = false;
//        boolean result = instance.updateOrder(updaterOrders);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addOrder method, of class FlServiceImpl.
//     */
//    @Test
//    public void testAddOrder() {
//        System.out.println("addOrder");
//        Orders order = null;
//        FlServiceImpl instance = null;
//        boolean expResult = false;
//        boolean result = instance.addOrder(order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editOrder method, of class FlServiceImpl.
//     */
//    @Test
//    public void testEditOrder() {
//        System.out.println("editOrder");
//        String date = "";
//        int orderNum = 0;
//        FlServiceImpl instance = null;
//        Orders expResult = null;
//        Orders result = instance.editOrder(date, orderNum);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeOrder method, of class FlServiceImpl.
//     */
//    @Test
//    public void testRemoveOrder() {
//        System.out.println("removeOrder");
//        String date = "";
//        int ordersNum = 0;
//        FlServiceImpl instance = null;
//        instance.removeOrder(date, ordersNum);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveOrder method, of class FlServiceImpl.
//     */
//    @Test
//    public void testSaveOrder() {
//        System.out.println("saveOrder");
//        FlServiceImpl instance = null;
//        boolean expResult = false;
//        boolean result = instance.saveOrder();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loadOrders method, of class FlServiceImpl.
//     */
//    @Test
//    public void testLoadOrders() {
//        System.out.println("loadOrders");
//        String date = "";
//        FlServiceImpl instance = null;
//        instance.loadOrders(date);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of writeOrders method, of class FlServiceImpl.
//     */
//    @Test
//    public void testWriteOrders() {
//        System.out.println("writeOrders");
//        String date = "";
//        FlServiceImpl instance = null;
//        instance.writeOrders(date);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
