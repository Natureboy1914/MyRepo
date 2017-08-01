/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.Ui;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Olayinka
 */
public interface UserIo {
    
     
    String readString(String prompt);
    
    BigDecimal bigDecimal(String prompt);
    
//    LocalDate theDate(String prompt);
    
    int pickItem(String prompt, int min, int max);
    
    int OrderNum(String prompt);
    
    void print(String msg);  
    
    
}
