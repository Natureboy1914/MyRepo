/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendmachinespmvc.Service;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Change {
    
 
    private BigDecimal Quarter;
    private BigDecimal Dime;
    private BigDecimal Nickel;
    private BigDecimal Pennies;
    
    
   

    /**
     * @return the Quarter
     */
    public BigDecimal getQuarter() {
        return Quarter;
    }

    /**
     * @param Quarter the Quarter to set
     */
    public void setQuarter(BigDecimal Quarter) {
        this.Quarter = Quarter;
    }

    /**
     * @return the Dime
     */
    public BigDecimal getDime() {
        return Dime;
    }

    /**
     * @param Dime the Dime to set
     */
    public void setDime(BigDecimal Dime) {
        this.Dime = Dime;
    }

    /**
     * @return the Nickel
     */
    public BigDecimal getNickle() {
        return Nickel;
    }

    /**
     * @param Nickel
     */
    public void setNickle(BigDecimal Nickel) {
        this.Nickel = Nickel;
    }

    /**
     * @return the Pennies
     */
    public BigDecimal getPennies() {
        return Pennies;
    }

    /**
     * @param Pennies the Pennies to set
     */
    public void setPennies(BigDecimal Pennies) {
        this.Pennies = Pennies;
    }
   
 

   
}
