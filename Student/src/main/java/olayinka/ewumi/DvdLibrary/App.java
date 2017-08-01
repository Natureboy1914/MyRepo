/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.DvdLibrary;

import Dvd.Controller.DvdController;
import Dvd.dao.DvdDao;
import Dvd.dao.DvdDaoFileImpl;
import Dvd.ui.DvdView;
import Dvd.ui.UserIo;
import Dvd.ui.UserIoConsoleImpl;

/**
 *
 * @author Olayinka
 */
public class App {
    public static void main(String[] args) {
    UserIo myIo = new UserIoConsoleImpl();
    DvdView myView = new DvdView(myIo);
    DvdDao myDao = new DvdDaoFileImpl();
    DvdController controller = 
            new DvdController(myDao, myView);
    controller.execute();
}
}
