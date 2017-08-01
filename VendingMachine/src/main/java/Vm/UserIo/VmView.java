/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.UserIo;

import VendingMachine.error.VendingEmptyInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Controller.VMController;
import Vm.Dto.VItems;
import Vm.Service.Change;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Olayinka
 */
public class VmView {

    private VmIo io;

    public VmView(VmIo io) {
        this.io = io;
    }

    public void welcomMenu() {

        io.print("====Welcome to Olayinka's Vending Machine=====");
        io.print("===============================================");

    }

    public BigDecimal getCash() {

        BigDecimal cash = io.bigDecimal("Please insert money before selecingt an Item from the menu");

        return cash;
    }
   
       
    public void displayChange(Change change){
        io.print("Here is your channge in Dollars: " + change.getDollar());
        io.print("Here is your channge in Quarters: " + change.getQuarter());
        io.print("Here is your channge in Dimes: " + change.getDime());
        io.print("Here is your channge in Nickels: " + change.getNickle());
        io.print("Here is your channge in Pennies: " + change.getPennies());
    }
       
        
    
    public void displayItemMenu(List<VItems> itemList) {
        for (VItems vItems : itemList) {
            io.print(vItems.getName() + ":................$"
                    + vItems.getCost() + " and has "
                    + vItems.getInventory() + " remaining in inventory");
        }
    }

public int menuSelection(){
    io.print("1. Select an Item ");
    io.print("2. Exit");
    
   int selection =  io.pickItem("select an option", 1,2);
    return selection;
}
    public String displayItemSelection() {
        return io.readString("Please Select an item");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
   public void displayInsufficientFundsException(VendingMachineExceptions e){
       io.print(e.getMessage());
   }
   
    
   public void displayInventoryException(VendingEmptyInventoryException e){
       io.print(e.getMessage());
   }
   
   public void displayExitMessage(){
       io.print("=====Bye======");
   }
}


    
     
    
