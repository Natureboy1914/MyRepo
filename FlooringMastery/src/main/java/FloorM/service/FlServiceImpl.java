/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.service;

import FloorM.dao.OrderDao;
import FloorM.dao.ProductDao;
import FloorM.dao.TaxDao;
import FloorM.dto.Orders;
import FloorM.dto.Products;
import FloorM.dto.Taxs;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ValidationException;

/**
 *
 * @author Olayinka
 */
public class FlServiceImpl implements FlService {

    ArrayList<Orders> userOrders = new ArrayList<>();

    OrderDao dao;
    ProductDao pdao;
    TaxDao tdao;

    public FlServiceImpl(OrderDao dao, ProductDao pdao, TaxDao tdao) {
        this.dao = dao;
        this.pdao = pdao;
        this.tdao = tdao;

    }

    private Orders calculateOrder(Orders userOrder) {

        Products newProd = pdao.getProduct(userOrder.getProductType());

        Taxs newTax = tdao.getTax(userOrder.getState());

        userOrder.setTaxRate(newTax.getTaxRate());
        userOrder.setCostPerSqFoot(newProd.getCostPerSquareFoot());
        userOrder.setLaborCostPerSqFoot(newProd.getLaborCostPerSquareFoot());

       String date = userOrder.getDate();
        userOrder.setOrderNumber(newOrderNum(date));

        userOrder.getOrderNumber();
        BigDecimal area = userOrder.getArea();
        BigDecimal taxRate = userOrder.getTaxRate();
        BigDecimal CPSF = userOrder.getCostPerSqFoot();
        BigDecimal LCPSF = userOrder.getLaborCostPerSqFoot();
        BigDecimal materialCost = CPSF.multiply(area);
        userOrder.setMaterialCost(materialCost);
        
         BigDecimal theTax = taxRate.divide(new BigDecimal(100));

        BigDecimal laborCost = LCPSF.multiply(area);
        userOrder.setLaborCost(laborCost);
        BigDecimal productCost = laborCost.add(materialCost);

        BigDecimal tax = productCost.multiply(theTax);
        userOrder.setTax(tax);
        
        BigDecimal total = productCost.add(tax);
        userOrder.setTotal(total);
        return userOrder;

    }

    @Override
    public void validateProductNameInput(String userSelection) throws ValidationProdException {

        List<Orders> order = new ArrayList<Orders>(userOrders);
        for (Orders o : order) {
            if (userSelection.equals(o.getProductType())) {
                System.out.println("We got a match");
            } else {
                throw new ValidationProdException("wrong entry");
            }
        }

    }

    

    @Override
    public void validateStateInput(String userSelection, Orders order) throws  Exception {

        if (userSelection.equals(order.getState())) {
            System.out.println("We got a match");

        } else {
            throw ValidationException("wrong entry");
        }

    }

    @Override
    public int newOrderNum(String date) {

        
        loadOrders(date);
       
        List<Orders> myOrders = dao.displasyOrder(date);

        int maxOrderNum = 1;
        for (Orders o : myOrders) {

            int orderNum = o.getOrderNumber();
            if (orderNum >= maxOrderNum) {
                maxOrderNum = orderNum;

            } 
        }
        maxOrderNum++;
             
        return maxOrderNum;
    }

    @Override
    public List<Orders> displasyOrder(String date) {
        List<Orders> order = dao.displasyOrder(date);

        return order;

    }

    public boolean updateOrder(Orders updaterOrders) {
        calculateOrder(updaterOrders);
        dao.addOrder(updaterOrders);

        return true;
    }

    @Override
    public boolean addOrder(Orders order) {

        return dao.addOrder(calculateOrder(order));
    }

    @Override
    public Orders editOrder(String date, int orderNum) {

        return dao.editOrder(date, orderNum);
    }

    @Override
    public void removeOrder(String date, int ordersNum) {

        dao.removeOrder(date, ordersNum);
    }

    @Override
    public boolean saveOrder() {

        dao.saveOrder();
        return true;
    }

    @Override
    public void loadOrders(String date) {
        try {
            dao.loadOrders(date);
        } catch (FileNotFoundException e) {
            System.out.println("NO!");
        }
    }

    @Override
    public void writeOrders(String date) {

        dao.writeOrders(date);
    }

    private Exception validationExceptions(String wrong_entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Exception ValidationException(String wrong_entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
