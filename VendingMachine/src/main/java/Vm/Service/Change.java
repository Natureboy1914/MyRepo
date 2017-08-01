/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Service;

import Vm.Dto.VItems;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class Change {
    
    private BigDecimal Dollar;
    private BigDecimal Quarter;
    private BigDecimal Dime;
    private BigDecimal Nickel;
    private BigDecimal Pennies;
    
    
     /**
     * @return the Dollar
     */
    public BigDecimal getDollar() {
        return Dollar;
    }

    /**
     * @param Dollar the Dollar to set
     */
    public void setDollar(BigDecimal Dollar) {
        this.Dollar = Dollar;
    }

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
   
   
//   BigDecimal Dollar = new BigDecimal("1");
//   BigDecimal Quarter = new BigDecimal(".25");
//   BigDecimal Dime = new BigDecimal(".10");
//   BigDecimal Nickle  = new BigDecimal(".05");
//   BigDecimal Pennie = new BigDecimal(".01");
//   
//   
//    
//    public BigDecimal calculateChange(BigDecimal userCash, List<VItems> vItem ){
//        VendingLogic service = new VendingLogic();
//        VItems vItems = new List<VItems>();
//        userCash = service.validatMoney(userCash, vItems);
//        
//        boolean keepRuning = true;
//        while(keepRuning){
//             switch () {
//            case 1:
//                userCash.compareTo(Dollar);
//                return Dollar;
//
//            case 2:
//                userCash.compareTo(Quarter);
//                return Quarter;
//            case 3:
//                    userCash.compareTo(Dime);
//                return Dime;
//                
//                 case 4:
//                    userCash.compareTo(Nickle);
//                return Nickle;
//                 case 5:
//                    userCash.compareTo(Pennie);
//                return Pennie;
//                
//                 case 6:
//                    keepRuning = false;
//
//            default: 
//                
//                for ()
//
//        }
//        
//        }
//    }

   
}