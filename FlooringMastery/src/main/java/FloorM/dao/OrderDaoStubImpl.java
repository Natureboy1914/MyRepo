/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Orders;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

///**
// *
// * @author apprentice
// */
public class OrderDaoStubImpl implements OrderDao  {
    
    Orders order1;
    Orders order2;
    
    ArrayList<Orders> userOrders = new ArrayList<>();
    
    
    
    public OrderDaoStubImpl(){
        
        order1 = new Orders();
        order1.setDate("03032017");
        order1.setOrderNumber(1);
        order1.setCustomerName("Ken");
        order1.setProductType("Wood");
        order1.setArea(new BigDecimal(100));
        order1.setState("OH");
        order1.setCostPerSqFoot(new BigDecimal (5.15));
        order1.setLaborCostPerSqFoot(new BigDecimal (4.75));
        order1.setMaterialCost(new BigDecimal (515));
        order1.setLaborCost(new BigDecimal (475));
        order1.setTaxRate(new BigDecimal (6.25));
        order1.setTax(new BigDecimal (61.875));
        order1.setTotal(new BigDecimal (1051.875));
        
        order2 = new Orders();
        order2.setDate("03032017");
        order1.setOrderNumber(2);
        order2.setCustomerName("Mike");
        order2.setProductType("Carpet");
        order2.setArea(new BigDecimal(300));
        order2.setState("MI");
        order2.setCostPerSqFoot(new BigDecimal (2.25));
        order2.setLaborCost(new BigDecimal (630));
        order2.setLaborCostPerSqFoot(new BigDecimal (2.10));
        order2.setMaterialCost(new BigDecimal (675));
        order2.setTaxRate(new BigDecimal (5.75));
        order2.setTax(new BigDecimal (75.0375));
        order2.setTotal(new BigDecimal (1382.0375));
        
        userOrders.add(order1);
        userOrders.add(order2);
     
    }
    
    
    
    
    

    @Override
    public List<Orders> displasyOrder(String date) {
               return userOrders;
    }

    @Override
    public boolean addOrder(Orders order) {
       return true;
    }

    @Override
    public Orders editOrder(String date, int orderNum) {
        Orders ord = new Orders();
        return ord;
    }

    @Override
    public void removeOrder(String date, int orderNum) {
        
    }   

    @Override
    public void writeOrders(String date) {
        
    }

    @Override
    public void loadOrders(String date) throws FileNotFoundException {
       
    }

    @Override
    public boolean saveOrder() {
       return true;
    }

    
}
