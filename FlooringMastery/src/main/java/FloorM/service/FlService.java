/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.service;

import FloorM.dto.Orders;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public interface FlService {
    
    List<Orders> displasyOrder(String date);
    
    boolean addOrder(Orders order);
    
    void validateProductNameInput(String userSelection) throws ValidationProdException ;
       
       void validateStateInput(String userSelection, Orders order) throws Exception ;
    
    Orders editOrder(String date, int orderNum);
    
    void removeOrder(String date, int orderNum);
    
    int newOrderNum(String date);
    
     boolean saveOrder();
     
    void loadOrders(String date);
    
    void writeOrders(String date);
    
    
}
