/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Service;

import VendingMachine.error.VendingEmptyInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Dao.VmAuditDao;
import Vm.Dao.VmDao;
import Vm.Dto.VItems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Olayinka
 */
public class VmServiceImpl implements VmService {

    private VmDao dao;
    
    
     HashMap<String, VItems> items = new HashMap<>();

    public VmServiceImpl(VmDao dao ) {
        this.dao = dao;
        
    }

 
    @Override
    public List<VItems> retieveItem() {

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
    public VItems getItem(String userSelection){
        
        
         for (VItems v : dao.vItems()) {

            String itemName = v.getName();

            if (userSelection.equalsIgnoreCase(itemName)) {
                return v;
            }
         }
        return null;
    }
    
    @Override
    public void decrementInventory(List<VItems> vItems) {
        vItems = dao.vItems();
        for (VItems v : vItems) {
            int newInventory;
            newInventory = v.getInventory() - 1;
            v.setInventory(newInventory);
        }
    }

    public VItems itemName(String userSelection) {
        List<VItems> v = dao.vItems();
        for (VItems vItem : v) {
            String itemName = vItem.getName();

            if (userSelection.equalsIgnoreCase(itemName)) {
                return vItem;
            }

        }
        return null;
    }
    
    public void updateItem(String userSelection){
        dao.updateItems(userSelection);
    }

    @Override
    public Change vend(BigDecimal userCash, String userSelection) {
        BigDecimal itemCost = new BigDecimal("0");
        BigDecimal differenceOfMoney;
        List<VItems> vItems = dao.vItems();

        for (VItems v : vItems) {
            String itemName = v.getName();

            if (userSelection.equalsIgnoreCase(itemName)) {
                itemCost = v.getCost();
            }

        }

        differenceOfMoney = userCash.subtract(itemCost);

        double hundred = 1.00;
        double twentyFive = .25;
        double ten = .10;
        double five = .5;
        double one = .01;

        int Dollar = differenceOfMoney.divide(BigDecimal.valueOf(hundred)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Dollar).multiply(BigDecimal.valueOf(hundred)));

        int Quarter = differenceOfMoney.divide(BigDecimal.valueOf(twentyFive)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Quarter).multiply(BigDecimal.valueOf(twentyFive)));

        int Dime = differenceOfMoney.divide(BigDecimal.valueOf(ten)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Dime).multiply(BigDecimal.valueOf(ten)));

        int Nickel = differenceOfMoney.divide(BigDecimal.valueOf(five)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Nickel).multiply(BigDecimal.valueOf(five)));

        int Pennie = differenceOfMoney.divide(BigDecimal.valueOf(one)).intValue();
        differenceOfMoney = differenceOfMoney.subtract(BigDecimal.valueOf(Pennie).multiply(BigDecimal.valueOf(one)));

        Change newChange = new Change();

        newChange.setDollar(BigDecimal.valueOf(Dollar));
        newChange.setQuarter(BigDecimal.valueOf(Quarter));
        newChange.setDime(BigDecimal.valueOf(Dime));
        newChange.setNickle(BigDecimal.valueOf(Nickel));
        newChange.setPennies(BigDecimal.valueOf(Pennie));

        return newChange;

    }

    @Override
    public List<VItems> vItems() {
        return new ArrayList<VItems>(items.values());
    }

    @Override
    public HashMap getAllItem() {
        return items;
    }

    @Override
    public void updateItems(String userSelection) {
        items.get(userSelection).updatItem();
    }
}
