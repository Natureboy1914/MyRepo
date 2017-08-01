/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.Controller;

import Dvd.dao.DvdDao;
import Dvd.dao.DvdDaoFileImpl;
import Dvd.dto.Dvd;
import Dvd.ui.DvdView;
import Dvd.ui.UserIo;
import Dvd.ui.UserIoConsoleImpl;
import java.util.List;
import olayinka.ewumi.DvdLibrary.Exception.DvdDaoException;

/**
 *
 * @author Olayinka
 */
public class DvdController {
    
    private UserIo io = new UserIoConsoleImpl();
    
    DvdView view;
    DvdDao dao;
    
    public DvdController(DvdDao dao, DvdView view) {
    this.dao = dao;
    this.view = view;
}
    
        
     
     public void welcomeMenu(){
         io.print("Welcome to the Menu");
         io.print("=====================");
         
         io.print("Initial Menu: ");
         io.print("Please select an operation you would to perform: ");
         io.print("======================");
     }
     
     public void execute(){
         boolean keepRuning = true;
         int menuSelection = 0;
         while(keepRuning){
             io.print("1. Add DVD to your collection");
             io.print("2. Remove DVD from your collection");
             io.print("3. Edit DVD collection");
             io.print("4. Serch DVD by Title");
             io.print("5. List DVD collection");
             io.print("6. Exit");
             
             menuSelection = io.readInt("Select an option between 1-6", 1, 6);
             
             switch(menuSelection){
                 case 1:
                     createDvd();
                     break;
                case 2:
                     removeDvd();
                     break;
                     
                case 3:
                     io.print("EDIT DVD");
                     break;
                     
                case 4:
                     io.print("SEARCH DVD");
                     break;
                     
                case 5:
                     listDvd();
                     break;
                     
                case 6:
                     keepRuning = false;
                     break;
                
                default:
                    unknownCommand();
             }
         }
         exitMessage(); 
     }catch (DvdDaoException e) {
	        view.displayErrorMessage(e.getMessage());
     }
     private int getMenuSelection(){
         
     }
     
     private void createDvd throws DvdDaoException(){
         view.displayCreateDvdBanner();
         Dvd newDvd = view.getNewDvd();
	    dao.addDvd(newDvd.getDvdId(), newDvd);
	    view.displayCreateSuccessDvd();
         
     }
     
     private void listDvd throws DvdDaoException()() {
	    view.displayAllDvds();
	    List<Dvd> dvdList = dao.getAllDvd();
	    view.displayDvdList(dvdList);
	}
     
     private void viewDvd throws DvdDaoException()() {
	    view.displayDisplayDvdBanner();
	    String dvdId = view.getDvdIdChoice();
	    Dvd dvd = dao.getDvd(dvdId);
	    view.displayDvd(dvd);
	}
     
     private void removeDvd throws DvdDaoException()() {
	    view.displayRemoveDvdBanner();
	    String dvdId = view.getDvdIdChoice();
	    dao.removeDvd(dvdId);
	    view.displayRemoveSuccessDvd();
	}
     
     public void dvdMenuItemToEdit(){
         
         switch () {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        }
     }
     
     
     
     
     private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitDvdBanner();
}


}
