/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.vendingmachine;

import Vm.Controller.VMController;
import Vm.Dao.VmAuditDao;
import Vm.Dao.VmAuditDaoStubImpl;
import Vm.Dao.VmDao;
import Vm.Dao.VmDaoFileImpl;
import Vm.Service.VmServiceImpl;
import Vm.UserIo.VmIo;
import Vm.UserIo.VmUserIoImpl;
import Vm.UserIo.VmView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Olayinka
 */
public class App {
    public static void main(String[] args) throws Exception{
//         VmIo Io = new VmUserIoImpl();
//    VmView myView = new VmView(Io);
//    VmDao myDao = new VmDaoFileImpl();
//    VmAuditDao auditDao = new VmAuditDaoStubImpl();
//     VmServiceImpl service = new VmServiceImpl(myDao, auditDao);
//    VMController controller = new VMController(service, myView);
//    controller.execute();
  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    VMController controller = ctx.getBean("controller", VMController.class);
   
    controller.execute();
    }
    
  
    }

