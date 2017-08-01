/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import Vm.Dto.VItems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class VmDaoStubImpl implements VmDao {

    VItems itemOne;
    VItems itemTwo;
    
    private HashMap<String, VItems> items = new HashMap<>();
    
    public VmDaoStubImpl(){
        itemOne = new VItems();
        itemOne.setName("BeefSticks");
        itemOne.setCost(BigDecimal.valueOf(2.50));
        itemOne.setInventory(6);
        
        itemTwo = new VItems();
        itemTwo.setName("Doritoz");
        itemTwo.setCost(BigDecimal.valueOf(2.50));
        itemTwo.setInventory(3);
        
        items.put(itemOne.getName(), itemOne);
        items.put(itemTwo.getName(), itemTwo);
    }

    @Override
    public List<VItems> vItems()  {
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
