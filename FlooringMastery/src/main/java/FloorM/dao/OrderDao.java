/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Orders;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public interface OrderDao {
    
       List<Orders> displasyOrder(String date);
        
       boolean addOrder(Orders order);
       
        
       Orders editOrder(String date, int orderNum);
       
       void removeOrder(String date, int orderNum);
       
       boolean saveOrder();
       
        void writeOrders(String date);
        
        void loadOrders(String date) throws FileNotFoundException;

}
