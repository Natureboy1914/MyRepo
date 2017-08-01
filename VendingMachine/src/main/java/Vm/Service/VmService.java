/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Service;

import VendingMachine.error.VendingEmptyInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Dto.VItems;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public interface VmService {
    
    List<VItems> vItems();
    
    HashMap getAllItem();
    public List<VItems> retieveItem();
    
    void updateItems(String userSelection);
    
    void validateMoney(String userSelection, BigDecimal cash) throws VendingMachineExceptions ;
    
    Change vend(BigDecimal userCash, String userSelection);
    
    void decrementInventory(List<VItems> vItems);
    
    public void validateInventory(VItems vItem) throws VendingEmptyInventoryException;
    
    VItems getItem(String userSelection);

   
}
