/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.ui;

import Dvd.dto.Dvd;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class DvdView {
   
     private UserIo io;
     
     public DvdView(UserIo io) {
    this.io = io;
}
    
    public Dvd getNewDvd(){
        String dvdId = io.readString("Please enter in Dvd's Id");
        String title = io.readString("Please enter the name of the Dvd");
        String releaseDate = io.readString("Please enter the release date");
	String rating = io.readString("Please give a rating ");
	String directorsName = io.readString("Please enter the name of the director");
        String studio = io.readString("Please enter the name of the studio");
       
	    Dvd newDvd = new Dvd(dvdId);
	    newDvd.setTitle(title);
	    newDvd.setReleaseDate(releaseDate);
            newDvd.setRating(rating);
            newDvd.setDirectorsName(directorsName);
            newDvd.setStudio(studio);
	   
	    return newDvd;
    }
    
    public void displayCreateDvdBanner() {
	    io.print("=== Create Dvd ===");
	}
    
    public void displayCreateSuccessDvd() {
	    io.readString(
	            "Dvd was successfully created.  Please hit enter to continue");
	}
    
    public void displayDvdList(List<Dvd> dvdList) {
	    for (Dvd newDvd : dvdList) {
	        io.print(newDvd.getDvdId() + ": "
	                + newDvd.getTitle() + " "
                         + newDvd.getReleaseDate() + " "
                         + newDvd.getRating() + " "
                        + newDvd.getStudio() + " "
                       
	                + newDvd.getDirectorsName());
	    }
	    io.readString("Please hit enter to continue.");
	}
    public void displayAllDvds() {
	    io.print("=== Display All Dvds ===");
	}
    
    	public void displayDisplayDvdBanner () {
	    io.print("=== Display Dvd ===");
	}

	public String getDvdIdChoice() {
	    return io.readString("Please enter the Student ID.");
	}

	public void displayDvd(Dvd dvd) {
	    if (dvd != null) {
	        io.print(dvd.getDvdId());
	        io.print(dvd.getTitle());
	        io.print(dvd.getReleaseDate());
                io.print(dvd.getRating());
                io.print(dvd.getDirectorsName());
                io.print(dvd.getStudio());
                
	        io.print("");
	    } else {
	        io.print("No such Dvd.");
	    }
	    io.readString("Please hit enter to continue.");
	}
        
        public void displayRemoveDvdBanner () {
	    io.print("=== Remove Dvd ===");
	}

	public void displayRemoveSuccessDvd () {
	    io.readString("Dvd successfully removed. Please hit enter to continue.");
	}
	
        public void displayExitDvdBanner() {
        io.print("Good Bye!!!");
}

        public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
}
        
        public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
        
     
	
}  

