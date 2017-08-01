/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Products;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class ProductStubDaoImpl implements ProductDao {
    
    Products p;
    
    HashMap<String, Products> prod = new HashMap<>();
    
    public ProductStubDaoImpl(){
        p = new Products();
        p.setProductType("Carpet");
        p.setCostPerSquareFoot(new BigDecimal(2.25));
        p.setLaborCostPerSquareFoot(new BigDecimal(2.10));
        
        prod.put("Carpet", p);
        
    }

    @Override
    public Products getProduct(String productName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
