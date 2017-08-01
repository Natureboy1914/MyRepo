/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.Ui;


import FloorM.dto.Orders;
import static java.lang.System.out;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class FlView {
    
    UserIo io;
    
   public FlView(UserIo io){
       this.io = io;
   }
   
    public void welcomMenu() {

        io.print("====Welcome to the SWC Corp Flooring Serrvice=====");
        io.print("===============================================");
    }
    
   public String dateEntery() {
     
   
        return io.readString("Please enter date.");
    }
   
   public int OrderNum(){
       
       return io.OrderNum("Pleas enter order Num");
   }
   
   
    public Orders makeNewOrder(){
        String date = io.readString("Please enter the date");
        String name = io.readString("Please enter your name");
        String materialType = io.readString("Please enter the name of the material");
	String state = io.readString("Please enter the name of your state ");
	BigDecimal area = io.bigDecimal("Please enter the area of the material");
        
       
//	    List<Orders> order = new ArrayList<Orders>(date);
    Orders order = new Orders();
            order.setDate(date);
	    order.setCustomerName(name);
            order.setProductType(materialType);
            order.setState(state);
	    order.setArea(area);
            
	   
	    return order;
    }
    
    public void showOrder(List<Orders> ord){
         for(Orders o: ord){
            out.print(o.getOrderNumber() + ""
                    + o.getCustomerName() + ""
                    + o.getProductType()+ ""
                    + o.getState() + ""
                    + o.getTaxRate() + ""
                    + o.getArea()+ ""
                    + o.getCostPerSqFoot() + ""
                    + o.getLaborCostPerSqFoot() + ""
                    + o.getMaterialCost() + ""
                    + o.getLaborCost() + ""
                    + o.getTax() + ""
                    + o.getTotal());
            
         }
    }
   
  public int displayMenuSelection(){
      io.print("Please select a choice from the menu ");
     
    io.print("1: Display all orders ");
    io.print("2: Create a new Order ");
    io.print("3: Edit an Order ");
    io.print("4: Remove an Order ");
    io.print("5: Save current work ");
    io.print("6: Exit ");
    
   
   int selection =  io.pickItem("select an option", 1,6);
    return selection;
}
  
  public Orders newEditedOrder (Orders ord){
       String date = io.readString("Please enter the date");
        String name = io.readString("Please enter your name");
        String materialType = io.readString("Please enter the name of the material");
	String state = io.readString("Please enter the name of your state ");
	BigDecimal area = io.bigDecimal("Please enter the area of the material");
        
       
//	    List<Orders> order = new ArrayList<Orders>(date);
    Orders order = new Orders();
            order.setDate(date);
	    order.setCustomerName(name);
            order.setProductType(materialType);
            order.setState(state);
	    order.setArea(area);
      
            return order;
  }
  
 
  
  
  public int commit(){
      
       int userChoice = io.pickItem("would you like to save.....Y/N \n 1 for Y \n 2 for N ", 1,2);
                
     return userChoice;
  }
  
  public String delete(){
      return io.readString("would you like to delete this order.....Y/N");
  }
  
  public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
  
   public void displayException(ValidationProdExceptions e){
       io.print(e.getMessage());
   }
   
   public void returnToMainMenu(){
       io.print("Returning to main menu");
   }
   
   public void displayExitMessage(){
       io.print("=====Bye======");
   }
   
    
   public void SuccessMessage(){
       io.print(" successefully exicuted ");
   }
    
  
   
     
     public void errorMessage(){
         io.print("Sorry that order does not exist");
     }
   
    
}
