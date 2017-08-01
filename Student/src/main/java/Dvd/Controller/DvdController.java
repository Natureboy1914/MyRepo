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
                     editDvd();
                     break;
                     
                case 4:
                     searchDvd();
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
    
     }
   
     private void createDvd(){
         view.displayCreateDvdBanner();
         Dvd newDvd = view.getNewDvd();
	    dao.addDvd(newDvd.getDvdId(), newDvd);
	    view.displayCreateSuccessDvd();
         
     }
     
     private void listDvd () {
	    view.displayAllDvds();
	    List<Dvd> dvdList = dao.getAllDvd();
	    view.displayDvdList(dvdList);
	}
     
     private void viewDvd() {
	    view.displayDisplayDvdBanner();
	    String dvdId = view.getDvdIdChoice();
	    Dvd dvd = dao.getDvd(dvdId);
	    view.displayDvd(dvd);
	}
     
     private void removeDvd () {
	    view.displayRemoveDvdBanner();
	    String dvdId = view.getDvdIdChoice();
	    dao.removeDvd(dvdId);
	    view.displayRemoveSuccessDvd();
	}
     
     private void editDvd(){
         view.displayEditDvdBanner();
         String dvdId = view.getDvdIdChoice();
         Dvd newDvd = dao.getDvd(dvdId);
         view.getEditedDvd(newDvd);
     }
     
     public void searchDvd(){
         view.displaySearchBanner();
        String searchTerm = view.getDvdLookUp();
       List<Dvd> dvdList =  dao.searchDvd(searchTerm);
         view.displayDvdList(dvdList);
     }
     
     
     
     
     
     private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitDvdBanner();
    
}


}
