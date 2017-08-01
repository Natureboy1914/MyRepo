/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Dao;

import com.sg.vendmachinespmvc.Model.VItems;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VmDao {
    
     List<VItems> vItems();
    
   HashMap getAllItem();
   
     void updateItems(String userSelection);
 
    VItems getItem(String name); 
}
