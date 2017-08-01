package com.sg.vendmachinespmvc.Controller;

import com.sg.vendmachinespmvc.Dao.VmDao;
import com.sg.vendmachinespmvc.Service.VmService;
import com.sg.vendmachinespmvc.Service.VmServiceImpl;
import java.util.List;
import java.util.Map;
import com.sg.vendmachinespmvc.Model.VItems;
import com.sg.vendmachinespmvc.Service.Change;
import errorExceptions.VendingEmptyInventoryException;
import errorExceptions.VendingMachineExceptions;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VendingController {

    VmService service;

    private String selectedItem;
   
    private BigDecimal remainderAmount;
    private BigDecimal changeAmount;
//  private BigDecimal userMoneyN;
//  private BigDecimal userMoneyP;
    private BigDecimal totalMoney = new BigDecimal(0);
   private String correctChange;
    private String Message;
    private Change myChange;

    

    @Inject
    public VendingController(VmService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Items(Model model) {
        List<VItems> myItems = service.retrieveItem();
        model.addAttribute("VItems", myItems);
        model.addAttribute("selectedItem", selectedItem);
        model.addAttribute("remainderAmount", remainderAmount);
        model.addAttribute("changeAmount", changeAmount);
        model.addAttribute("correctChange", correctChange);
//      model.addAttribute("userMoneyN", userMoneyN);
//      model.addAttribute("userMoneyP", userMoneyP);
        model.addAttribute("Message", Message);
        model.addAttribute("totalMoney", totalMoney);
//        model.addAttribute("myChange", myChange);
        
        return "index";
    }

    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    public String postItems(String name) {
        VItems v = service.getItem(name);

        if (v == null) {
            selectedItem = null;
        } else {
            selectedItem = v.getName();
        }
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/addQuarters", method = RequestMethod.GET)
    public String getQuarter(){
        totalMoney = service.addQuarters(totalMoney);

        return "redirect:/";

    }
    
     @RequestMapping(value = "/addDimes", method = RequestMethod.GET)
    public String getDime(){
        totalMoney = service.addDimes(totalMoney);
        
        return "redirect:/";

    }
    
     @RequestMapping(value = "/addNickels", method = RequestMethod.GET)
    public String getNickel(){
        totalMoney = service.addNickels(totalMoney);

        return "redirect:/";

    }
    
     @RequestMapping(value = "/addPennies", method = RequestMethod.GET)
    public String getPennies(){
        totalMoney = service.addPennies(totalMoney);
       
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase() {
        
        VItems v = service.getItem(selectedItem);
        remainderAmount = v.getCost().subtract(totalMoney);
           
        
        try {
            service.validateMoney(v.getName(), totalMoney);
        } catch (VendingMachineExceptions ex) {
           Message = "Please add "+remainderAmount ;
            return "redirect:/";
        }
        
        try {
            service.validateInventory(v);
        } catch (VendingEmptyInventoryException ex) {
           Message = "There are no more items ";
            return "redirect:/";
        }
        
//        service.decrementInventory(v);
        service.updateItems(selectedItem);
       
        changeAmount= totalMoney.subtract(v.getCost());
        
       myChange = service.vend(changeAmount);
       
       
       correctChange = "Quarters: " + myChange.getQuarter() + " Dimes: " + myChange.getDime() + " Nickels: " +myChange.getNickle() + " Pennies: "+  myChange.getPennies();
        
        Message = "Good Purchase";
        totalMoney = new BigDecimal(0);
        myChange = null;
        return "redirect:/";
        
    }
    
   
    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String returnChange(){
        
      myChange =  service.vend(totalMoney);
      
      correctChange = "Quarters: " + myChange.getQuarter() + " Dimes: " + myChange.getDime() + " Nickels: " +myChange.getNickle() + " ennies: "+  myChange.getPennies();
      myChange = null;
        return "redirect:/";
        
    }
    
    
}
