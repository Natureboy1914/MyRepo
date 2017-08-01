/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.dao;

import Dvd.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.State.values;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import olayinka.ewumi.DvdLibrary.Exception.DvdDaoException;

/**
 *
 * @author Olayinka
 */
      public class DvdDaoFileImpl implements DvdDao {

          public static final String DVD_FILE = "dvd.txt";
            public static final String DELIMITER = "::";
            
           Map<String, Dvd> dvd = new HashMap<>();
          
          @Override
	   public Dvd addDvd(String dvdId, Dvd dvd){
                 throws DvdDaoException {
	    Dvd newDvd = dvd.put(dvdId, dvd);
	    writeDvd();
	    return newDvd;
            }
	    
	  @Override
	public List<Dvd> getAllDvd() 
	 throws DvdDaoException {
	    loadDvd();
	    return new ArrayList<Dvd>(dvd.values());
	}
	    
	  @Override
	public Dvd getDvd(String dvdId) 
	 throws DvdDaoException {
	    loadDvd();
	    return dvd.get(dvdId);
	}
	
	    
	   @Override
	public Dvd removeDvd(String dvdId) 
	 throws DvdDaoException {
	    Dvd removeDvd = dvd.remove(dvdId);
	    writeDvd();
	    return removeDvd;
	}
            }
            
            private void loadDvd() throws DvdDaoException {
	    Scanner scanner;
	    
	    try {
	       
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DvdDaoException(
	                "-_- Could not load Dvd data into memory.", e);
	    }
	    
	    String currentLine;
	
	    String[] currentTokens;
	  
	    while (scanner.hasNextLine()) {
	       
	        currentLine = scanner.nextLine();
	      
	        currentTokens = currentLine.split(DELIMITER);
	       
	        Dvd newDvd = new Dvd(currentTokens[0]);
	       
	        newDvd.setTitle(currentTokens[1]);
	        newDvd.setReleaseDate(currentTokens[2]);
	        newDvd.setRating(currentTokens[3]);
                 newDvd.setDirectorsName(currentTokens[4]);
                  newDvd.setStudio(currentTokens[5]);
                
	        
	        
	        dvd.put(newDvd.getDvdId(), newDvd);
	    }
	    // close scanner
	    scanner.close();
	}
            
            private void writeDvd() throws DvdDaoException {
	    
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DvdDaoException(
	                "Could not save Dvd data.", e);
	    }
	    
	   
	    List<Dvd> dvdList = this.getAllDvd();
	    for (Dvd newDvd : dvdList) {
	       
	        out.println(newDvd.getDvdId() + DELIMITER
	                + newDvd.getTitle() + DELIMITER 
	                + newDvd.getReleaseDate() + DELIMITER
                          + newDvd.getRating() + DELIMITER
                          + newDvd.getDirectorsName() + DELIMITER
                          + newDvd.getStudio());
	                
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
	
}
