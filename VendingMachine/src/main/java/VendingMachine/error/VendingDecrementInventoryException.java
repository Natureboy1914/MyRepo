/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.error;

/**
 *
 * @author Olayinka
 */
public class VendingDecrementInventoryException extends Exception {
    
    
    public VendingDecrementInventoryException (String message) {
        super(message);
        
    }
}
