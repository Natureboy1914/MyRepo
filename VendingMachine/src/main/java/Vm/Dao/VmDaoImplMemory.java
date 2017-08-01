/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import Vm.Dto.VItems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
//public class VmDaoImplMemory implements VmDao {
//    
//      HashMap<String, VItems> items = new HashMap<>();
//    
//    VItems Snikers = new VItems();
//    VItems MinniDonutes = new VItems();
//    VItems Pretzels = new VItems();
//     VItems Doritoz = new VItems();
//      VItems Crackers = new VItems();
//       VItems BeefSticks = new VItems();
//       VItems Gum = new VItems();
//        VItems TrailMix = new VItems();
//    
//    
//    public VmDaoImplMemory(){
//        
//        Snikers.setName("Snikers");
//        Snikers.setCost(new BigDecimal("2.00"));
//        Snikers.setInventory( 5);
//        items.put(Snikers.getName(), Snikers);
//        
//        
//        MinniDonutes.setName("MinniDonutes");
//        MinniDonutes.setCost(new BigDecimal("3.00"));
//        MinniDonutes.setInventory( 4);
//        items.put(MinniDonutes.getName(), MinniDonutes);
//        
//         
//        Pretzels.setName("Pretzels");
//        Pretzels.setCost(new BigDecimal("1.50"));
//        Pretzels.setInventory( 6);
//        items.put(Pretzels.getName(), Pretzels);
//        
//        
//        Doritoz.setName("Doritoz");
//        Doritoz.setCost(new BigDecimal("2.50"));
//        Doritoz.setInventory( 4);
//        items.put(Doritoz.getName(), Doritoz);
//        
//        
//        Crackers.setName("Crackers");
//        Crackers.setCost(new BigDecimal("1.50"));
//        Crackers.setInventory( 3);
//        items.put(Crackers.getName(), Crackers);
//        
//        
//        BeefSticks.setName("BeefSticks");
//        BeefSticks.setCost(new BigDecimal("2.50"));
//        BeefSticks.setInventory( 3);
//        items.put(BeefSticks.getName(), BeefSticks);
//        
//         
//        Gum.setName("Gum");
//        Gum.setCost(new BigDecimal("1.00"));
//        Gum.setInventory( 2);
//        items.put(Gum.getName(), Gum);
//        
//        
//        TrailMix.setName("TrailMix");
//        TrailMix.setCost(new BigDecimal("1.00"));
//        TrailMix.setInventory( 1);
//        items.put(TrailMix.getName(), TrailMix);
//     
//        
//        
//    }
//    
//   
//  
//    @Override
//     public List<VItems> vItems(){
//          
//
//         return new ArrayList<VItems>(items.values());
//     }
//     
//    @Override
//   public  HashMap getAllItem(){
//        
//       return items;
//    }
//    
//    
//    
//    
//}
