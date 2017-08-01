/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import Vm.Dto.VItems;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Olayinka
 */
public interface VmDao  {
    
    List<VItems> vItems();
    
   HashMap getAllItem();
   
 void updateItems(String userSelection);
    
    
    
    
}
