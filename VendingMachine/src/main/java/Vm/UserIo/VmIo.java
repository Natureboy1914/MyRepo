/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.UserIo;

import java.math.BigDecimal;

/**
 *
 * @author Olayinka
 */
public interface VmIo {
    
    String readString(String prompt);
    
    BigDecimal bigDecimal(String prompt);
    
    int pickItem(String prompt, int min, int max);
    
    void print(String msg);  
}
