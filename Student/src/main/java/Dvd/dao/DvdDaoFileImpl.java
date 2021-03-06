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
    public Dvd addDvd(String dvdId, Dvd d) {

        Dvd newDvd = dvd.put(dvdId, d);
        writeDvd();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvd() {

        loadDvd();
        return new ArrayList<Dvd>(dvd.values());
    }

    @Override
    public Dvd getDvd(String dvdId) {

        loadDvd();
        return dvd.get(dvdId);
    }

    @Override
    public Dvd removeDvd(String dvdId) {
        Dvd removeDvd = dvd.remove(dvdId);
        writeDvd();
        return removeDvd;
    }

    private void loadDvd() {
        Scanner scanner = null;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
     
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

    private void writeDvd(){

        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
           
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

    @Override
    public List<Dvd> searchDvd(String title) {
        List<Dvd> dvdList = new ArrayList<>();
        for(Dvd dvd : getAllDvd()){
            if(dvd.getTitle().startsWith(title)){
                
                dvdList.add(dvd);
            }
                    
        }
        return dvdList;
    }

}
