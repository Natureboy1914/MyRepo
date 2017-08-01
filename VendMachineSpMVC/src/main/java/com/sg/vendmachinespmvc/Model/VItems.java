/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Model;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class VItems {
     
    private String name;
    private int inventory;
    private BigDecimal cost;
    
//    public VItems(String Name, int Inventory, BigDecimal cost){
//        this.Name = Name;
//        this.Inventory = Inventory;
//        this.cost = cost;
//        
//    }

   

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return the Inventory
     */
    public int getInventory() {
        return inventory;
    }
    
        public void updatItem() {
             inventory -= 1;
        }

    /**
     * @param Inventory the Inventory to set
     */
    public void setInventory(int Inventory) {
        this.inventory = Inventory;
    }

    /**
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    
    public String toSting(){
        
        return "Name: " + name + " |Cost: " + cost + " |Inventory: " + inventory;
        
    }
}
