/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dto;

import java.math.BigDecimal;

/**
 *
 * @author Olayinka
 */
public class VItems {
    
    private String Name;
    private int Inventory;
    private BigDecimal cost;

   

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Inventory
     */
    public int getInventory() {
        return Inventory;
    }
    
        public void updatItem() {
             Inventory -= 1;
        }

    /**
     * @param Inventory the Inventory to set
     */
    public void setInventory(int Inventory) {
        this.Inventory = Inventory;
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
        
        return "Name: " + Name + " |Cost: " + cost + " |Inventory: " + Inventory;
        
    }
}
