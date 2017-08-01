/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Orders;
import java.io.BufferedReader;
import static java.io.FileDescriptor.out;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import static sun.misc.MessageUtils.out;

/**
 *
 * @author Olayinka  *
 */
public class OrderDaoImpl implements OrderDao {

    ArrayList<Orders> userOrders = new ArrayList<>();
    String programMode;

    public OrderDaoImpl(String ProgramMode) {
        this.programMode = ProgramMode;
    }

    @Override
    public List<Orders> displasyOrder(String date) {

        return userOrders.stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());

    }

    @Override
    public boolean addOrder(Orders order) {

        userOrders.add(order);
        return true;
    }

    @Override
    public Orders editOrder(String date, int orderNum) {

        for (Orders o : userOrders) {
            if (date.equals(o.getDate()) || o.getOrderNumber() == orderNum) {
                return o;
            }

        }
        return null;
    }

    @Override
    public void removeOrder(String date, int orderNum) {

        try {
            loadOrders(date);
        } catch (FileNotFoundException e) {
//            Its fin not to do anything id there is no such date in the file
        }

        Orders theOrd = null;
        for (Orders o : userOrders) {
            if (date.equals(o.getDate()) && o.getOrderNumber() == orderNum) {
                theOrd = o;

            } else {
                System.out.println("There is no Order like that");
            }

        }

        System.out.println(userOrders.remove(theOrd));

    }

    @Override
    public boolean saveOrder() {
        userOrders.stream().forEach((Orders o) -> {
            writeOrders(o.getDate());
        });
        return true;
    }

    @Override
    public void loadOrders(String date) throws FileNotFoundException {

        Orders ord = new Orders();
        List<Orders> myOrder = userOrders;
        for (Orders o : myOrder) {
            if (ord != o) {

                System.out.println(o);
                return;
            }
        }

        String ORDERS_FILE = "Order_" + date + ".txt";
        String DELIMITER = "::";

        Scanner scanner = new Scanner(new BufferedReader(new FileReader(ORDERS_FILE)));

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            Orders order = new Orders();
            order.setDate(date);
            order.setOrderNumber(new Integer(currentTokens[0]));
            order.setCustomerName(currentTokens[1]);
            order.setProductType(currentTokens[2]);
            order.setState(currentTokens[3]);
            order.setTaxRate(new BigDecimal(currentTokens[4]));
            order.setArea(new BigDecimal(currentTokens[5]));
            order.setCostPerSqFoot(new BigDecimal(currentTokens[6]));
            order.setLaborCostPerSqFoot(new BigDecimal(currentTokens[7]));
            order.setMaterialCost(new BigDecimal(currentTokens[8]));
            order.setLaborCost(new BigDecimal(currentTokens[9]));
            order.setTax(new BigDecimal(currentTokens[10]));
            order.setTotal(new BigDecimal(currentTokens[11]));
            userOrders.add(order);

        }
        // close scanner
        scanner.close();
    }

    @Override
    public void writeOrders(String date) {
        String trainingMode = "training";

        if (!programMode.equalsIgnoreCase(trainingMode)) {

            String ORDERS_FILE = "Order_" + date + ".txt";
            String DELIMITER = "::";

            PrintWriter out = null;

            try {
                out = new PrintWriter(new FileWriter(ORDERS_FILE));
            } catch (IOException e) {

            }

            List<Orders> order = this.userOrders.stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());

            for (Orders o : order) {

                out.println(o.getOrderNumber() + DELIMITER
                        + o.getCustomerName() + DELIMITER
                        + o.getProductType() + DELIMITER
                        + o.getState() + DELIMITER
                        + o.getTaxRate() + DELIMITER
                        + o.getArea() + DELIMITER
                        + o.getCostPerSqFoot() + DELIMITER
                        + o.getLaborCostPerSqFoot() + DELIMITER
                        + o.getMaterialCost() + DELIMITER
                        + o.getLaborCost() + DELIMITER
                        + o.getTax() + DELIMITER
                        + o.getTotal());

            }
//             force PrintWriter to write line to the file
            out.flush();
            out.close();

        }

    }

}
