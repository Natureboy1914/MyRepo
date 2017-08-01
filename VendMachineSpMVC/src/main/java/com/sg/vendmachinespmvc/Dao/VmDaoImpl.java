/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Dao;

import com.sg.vendmachinespmvc.Model.VItems;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class VmDaoImpl implements VmDao {
    
     HashMap<String, VItems> items = new HashMap<>();
    
        
    public static final String VENDINGITEMS_FILE = "VendingItems.txt";
    public static final String DELIMITER = "::";

    @Override
    public List<VItems> vItems() {
        loadItems();
        return new ArrayList<VItems>(items.values());
    }

    @Override
    public HashMap getAllItem() {
        loadItems();
        return items;
    }
    
    @Override
    public void updateItems(String userSelection){
        
        items.get(userSelection).updatItem();
        writeItem();
    }
    
    @Override
    public VItems getItem(String name) {
       
//        
//         for (VItems v : vItems()) {
//
//            String itemName = v.getName();
//
//            if (userSelection.equalsIgnoreCase(itemName)) {
//                return v;
//            }
//         }
//         
//        return null;

    return items.get(name);
    }
        
        private void loadItems() {
        Scanner scanner = null;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader( getClass().getClassLoader().getResource(VENDINGITEMS_FILE).getFile())));
        } catch (FileNotFoundException e) {
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            VItems vItems = new VItems();

            vItems.setName(currentTokens[0]);
            vItems.setCost(new BigDecimal(currentTokens[1]));
             vItems.setInventory(Integer.parseInt(currentTokens[2]));
            
            items.put(vItems.getName(), vItems);
        }
        // close scanner
        scanner.close();
    }

        
        private void writeItem(){

        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(getClass().getClassLoader().getResource(VENDINGITEMS_FILE).getFile()));
        } catch (IOException e) {
           
        }

        List<VItems> vItems = this.vItems();
        for (VItems snacks : vItems ) {
            out.println(snacks.getName()+ DELIMITER
                    + snacks.getCost() + DELIMITER
                    + snacks.getInventory());
                    

//             force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
