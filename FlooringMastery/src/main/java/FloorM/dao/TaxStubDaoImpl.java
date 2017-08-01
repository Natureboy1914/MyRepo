/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Taxs;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class TaxStubDaoImpl implements TaxDao {
    
       
    Taxs t;
    
    HashMap<String, Taxs> tax = new HashMap<>();
 
    public TaxStubDaoImpl(){
        t = new Taxs();
        t.setState("MI");
        t.setTaxRate(new BigDecimal(5.75) );
        
        tax.put("MI", t);
        
    }
     

    @Override
    public Taxs getTax(String stateName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
