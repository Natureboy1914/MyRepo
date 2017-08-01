/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;


import FloorM.dto.Orders;
import FloorM.dto.Products;
import FloorM.dto.Taxs;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class ProductDaoImpl implements ProductDao  {
    
    
    public static final String PRODUCT_FILE = "Products.txt";
    public static final String DELIMITER = "::";
    
      
     Map<String,Products> prodName = new HashMap<>();

    @Override
    public Products getProduct(String productType) {
         loadProducts();
        Products prod = prodName.get(productType);
       
      return prod;
            
    }
    
    
    
    public void loadProducts(){
          Scanner scanner = null;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_FILE)));
            } catch (FileNotFoundException e) {
     
        }
        

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Products prod = new Products();
            
             
            prod.setProductType(currentTokens[0]);
           
            prod.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
            prod.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));
           
            prodName.put(prod.getProductType(), prod);
        }
//            
        
        // close scanner
        scanner.close();
        
        
        
    }
}
    
  
