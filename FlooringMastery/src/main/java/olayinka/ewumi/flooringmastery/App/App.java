/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.flooringmastery.App;

import FloorM.Ui.FlView;
import FloorM.Ui.UserIo;
import FloorM.Ui.UserIoImpl;
import FloorM.controller.FlController;
import FloorM.dao.OrderDao;
import FloorM.dao.OrderDaoImpl;
import FloorM.dao.ProductDao;
import FloorM.dao.ProductDaoImpl;
import FloorM.dao.TaxDao;
import FloorM.dao.TaxDaoImpl;
import FloorM.service.FlServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Olayinka
 */
public class App {
    public static void main(String[] args){
//       UserIo Io = new UserIoImpl();
//    FlView myView = new FlView(Io);
//    OrderDao Dao = new OrderDaoImpl();
//    ProductDao pdao = new ProductDaoImpl();
//    TaxDao tdao = new TaxDaoImpl();
////    VmAuditDao auditDao = new VmAuditDaoStubImpl();
//     FlServiceImpl service = new FlServiceImpl(Dao, pdao, tdao);
//    FlController controller = new FlController(service, myView);
//    
    
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    FlController controller = ctx.getBean("controller", FlController.class);
   
       controller.execute(); 
    }

    

}