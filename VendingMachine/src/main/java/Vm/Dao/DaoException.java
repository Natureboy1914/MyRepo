/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

/**
 *
 * @author Olayinka
 */
public class DaoException extends Exception {
     private final String message;
    
    public DaoException (String message) {
        this.message = message;
    }
    
}
