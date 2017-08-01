/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Service;

import VendingMachine.error.VendingEmptyInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Dao.DaoException;
import Vm.Dao.VmAuditDao;
import Vm.Dao.VmAuditDaoStubImpl;
import Vm.Dao.VmDao;
import Vm.Dao.VmDaoStubImpl;
import Vm.Dto.VItems;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Olayinka
 */
public class VendingLogicTest {
    
    private final VmService service;
    
    public VendingLogicTest() {
//        VmDao daoStub = new VmDaoStubImpl();
//        service = new  VmServiceImpl(daoStub);

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    service = ctx.getBean("serviceLayer",VmService.class );

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
     * Test of retieveItem method, of class VendingLogic.
     */
    @Test
    public void testRetieveItem() {
        assertEquals(2,service.retieveItem().size());
    }

    /**
     * Test of validateMoney method, of class VendingLogic.
     * @throws Vm.Dao.DaoException
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateMoney() throws DaoException {
        
//        List<VItems> v = service.vItems();
            try{
                service.validateMoney("Doritoz", BigDecimal.valueOf(5));
            }catch(VendingMachineExceptions e){
                fail("There is not enogh money");
            }
            
        
    }

    /**
     * Test of validateInventory method, of class VendingLogic.
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateInventory() throws DaoException {


    VItems vItem = service.getItem("Doritoz");
              
        try {
            service.validateInventory(vItem);
        } catch (VendingEmptyInventoryException ex) {
            fail("There are no more items in inventory");
        }
        

      

    }
    /**
     * Test of decrementInventory method, of class VendingLogic.
     */
    @Test
    public void testDecrementInventory()  {
 
        
        List<VItems> v = service.vItems();
        
        service.decrementInventory(v);
           int myInventory = 0;
        int newInventory = 0;
        
       
        for (VItems vItem : v) {
            if ("Doritoz".equals(vItem.getName())) {
                myInventory = vItem.getInventory();
            }
            
            service.updateItems("Doritoz");
              for (VItems vI : v) {
            if ("BeefSticks".equals(vI.getName())) {
                newInventory = vI.getInventory();
            }

        }
        assertEquals( myInventory - 1,newInventory );
        
    }
    }

    /**
     * Test of itemName method, of class VendingLogic.
     */
    @Test
    public void testItemName() {
    }

    /**
     * Test of updateItem method, of class VendingLogic.
     */
    @Test
    public void testUpdateItem() {
    }

    /**
     * Test of vend method, of class VendingLogic.
     * @throws Vm.Dao.DaoException
     * @throws java.lang.Exception
     */
    @Test
    public void testVend() {
        
         Change change = service.vend(BigDecimal.valueOf(9), "Doritoz");
         
         
          assertEquals(BigDecimal.valueOf(6),change.getDollar());
          
        assertEquals(BigDecimal.valueOf(2),change.getQuarter());
        

   
    }
    
}
