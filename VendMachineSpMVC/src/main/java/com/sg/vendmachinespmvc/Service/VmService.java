/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Service;

import com.sg.vendmachinespmvc.Model.VItems;
import errorExceptions.VendingEmptyInventoryException;
import errorExceptions.VendingMachineExceptions;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author apprentice
 */
public interface VmService {
    
   List<VItems> retrieveItem();

    void updateItems(String userSelection);
//    
    void validateMoney(String userSelection, BigDecimal cash) throws VendingMachineExceptions ;
    
    Change vend(BigDecimal userCash);
//    
//    void decrementInventory(VItems vItems);
//    
    public void validateInventory(VItems vItem) throws VendingEmptyInventoryException ;
    
    VItems getItem(String name);
    
    BigDecimal addQuarters(BigDecimal moneyAdded);
    
    BigDecimal addDimes(BigDecimal moneyAdded);
    
    BigDecimal addNickels(BigDecimal moneyAdded);
    
    BigDecimal addPennies(BigDecimal moneyAdded);
    
}
   

