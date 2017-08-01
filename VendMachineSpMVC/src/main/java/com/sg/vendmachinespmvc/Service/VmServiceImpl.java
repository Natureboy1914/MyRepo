/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Service;

import com.sg.vendmachinespmvc.Dao.VmDao;
import com.sg.vendmachinespmvc.Model.VItems;
import errorExceptions.VendingEmptyInventoryException;
import errorExceptions.VendingMachineExceptions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author apprentice
 */
public class VmServiceImpl implements VmService {

    private VmDao dao;

    HashMap<String, VItems> items = new HashMap<>();

    @Inject
    public VmServiceImpl(VmDao dao) {
        this.dao = dao;

    }

    @Override
    public List<VItems> retrieveItem() {

        return dao.vItems();
    }

    @Override
    public void validateMoney(String userSelection, BigDecimal cash ) throws VendingMachineExceptions {
         VItems v = getItem(userSelection);

            if (cash.compareTo(v.getCost()) >= 0) {

                 cash.subtract(v.getCost());
             
            }else {
                throw new VendingMachineExceptions("Insufficient funds please enter the right amount ");    
            }

        
       
    }


    @Override
    public void validateInventory(VItems vItem) throws VendingEmptyInventoryException {   
        int inStock;
        inStock = vItem.getInventory();
                if (inStock <= 0) {
                throw new VendingEmptyInventoryException ("There is no more Items of this in inventory please choose a different Item");

    }
    }

    
    @Override
    public VItems getItem(String name) {
        
     

        return dao.getItem(name);
    }

//    @Override
//    public void decrementInventory(VItems vItems) {
//        vItems = dao.getItem(vItems.getName());
//        
//            int newInventory;
//            newInventory = vItems.getInventory() - 1;
//            vItems.setInventory(newInventory);
//           updateItems(vItems.getName());
//        
//    }
////
//    public VItems itemName(String userSelection) {
//        List<VItems> v = dao.vItems();
//        for (VItems vItem : v) {
//            String itemName = vItem.getName();
//
//            if (userSelection.equalsIgnoreCase(itemName)) {
//                return vItem;
//            }
//
//        }
//        return null;
//    }
//   
//    
    @Override
    public void updateItems(String userSelection) {
        dao.updateItems(userSelection);
    }

    
    
    
    
    

    @Override
    public Change vend(BigDecimal userCash) {
        BigDecimal itemCost = new BigDecimal("0");
        BigDecimal differenceOfMoney;

        differenceOfMoney = userCash.subtract(itemCost);

        double twentyFive = .25;
        double ten = .10;
        double five = .5;
        double one = .01;

        int Quarter = differenceOfMoney.divide(BigDecimal.valueOf(twentyFive)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Quarter).multiply(BigDecimal.valueOf(twentyFive)));

        int Dime = differenceOfMoney.divide(BigDecimal.valueOf(ten)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Dime).multiply(BigDecimal.valueOf(ten)));

        int Nickel = differenceOfMoney.divide(BigDecimal.valueOf(five)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Nickel).multiply(BigDecimal.valueOf(five)));

        int Pennie = differenceOfMoney.divide(BigDecimal.valueOf(one)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Pennie).multiply(BigDecimal.valueOf(one)));

        Change newChange = new Change();

        newChange.setQuarter(BigDecimal.valueOf(Quarter));
        newChange.setDime(BigDecimal.valueOf(Dime));
        newChange.setNickle(BigDecimal.valueOf(Nickel));
        newChange.setPennies(BigDecimal.valueOf(Pennie));

        return newChange;

    }
    
    

    @Override
    public BigDecimal addQuarters(BigDecimal moneyAdded) {
        BigDecimal quarter = new BigDecimal(".25");

        moneyAdded = moneyAdded.add(quarter);

        return moneyAdded;
    }

    @Override
    public BigDecimal addDimes(BigDecimal moneyAdded) {
        BigDecimal dime = new BigDecimal(".10");

        moneyAdded = moneyAdded.add(dime);

        return moneyAdded;
    }

    @Override
    public BigDecimal addNickels(BigDecimal moneyAdded) {
        BigDecimal nickel = new BigDecimal(".05");

        moneyAdded = moneyAdded.add(nickel);

        return moneyAdded;
    }

    @Override
    public BigDecimal addPennies(BigDecimal moneyAdded) {
        BigDecimal penny = new BigDecimal(".01");

        moneyAdded = moneyAdded.add(penny);

        return moneyAdded;
    }

}
