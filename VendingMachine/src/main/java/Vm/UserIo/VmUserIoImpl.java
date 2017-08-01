/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.UserIo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class VmUserIoImpl implements VmIo {
    
    Scanner sc = new Scanner(System.in);
    
    

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userInput;
        userInput = sc.nextLine();
        return userInput;
    }
    
    @Override
    public int pickItem(String prompt, int min, int max){
        System.out.println(prompt);
        int itemNumber;
        do{
            String userInput;
            
            userInput = sc.nextLine();
            itemNumber = Integer.parseInt(userInput);
            return itemNumber;
        }while(itemNumber < min || itemNumber > max);
    }

    @Override
    public BigDecimal bigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal bigDec;
        bigDec = sc.nextBigDecimal();
        sc.nextLine();
        return bigDec;
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
    
}
