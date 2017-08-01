/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Service;

/**
 *
 * @author Olayinka
 */
public class serviceException extends Exception{
     private final String message;
    
    public serviceException (String message) {
        this.message = message;
    }
    
}
