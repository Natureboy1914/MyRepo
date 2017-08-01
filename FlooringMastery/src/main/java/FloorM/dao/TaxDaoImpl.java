/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;


import FloorM.dto.Orders;
import FloorM.dto.Taxs;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class TaxDaoImpl implements TaxDao {
    
    public static final String TAXS_FILE = "Taxs.txt";
    public static final String DELIMITER = "::";
    
    
    
    
    HashMap<String,Taxs> stateTax = new HashMap<>();

    @Override
    public Taxs getTax(String stateName) {
         loadTax();
           Taxs sTax = stateTax.get(stateName);
              
               return sTax;

    }
         
    public void loadTax(){
        
        Scanner scanner = null;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXS_FILE)));
        } catch (FileNotFoundException e) {
     
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Taxs tax = new Taxs();
  
            tax.setState(currentTokens[0]);
            tax.setTaxRate( new BigDecimal(currentTokens[1]));
            
            stateTax.put(tax.getState(), tax);
          

        }
        // close scanner
        scanner.close();
        
        
    }
    
    
    
    
           
    }
    
