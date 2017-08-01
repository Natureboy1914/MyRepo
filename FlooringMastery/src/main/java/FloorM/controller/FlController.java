/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.controller;

import FloorM.Ui.FlView;
import FloorM.dto.Orders;
import FloorM.service.FlService;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class FlController {

    FlService serv;
    FlView view;

    public FlController(FlService serv, FlView view) {
        this.serv = serv;
        this.view = view;
    }

    public void execute() {

        boolean keepRuning = true;
        while (keepRuning) {
            view.welcomMenu();
            int userSelection = view.displayMenuSelection();

            switch (userSelection) {

                case 1:
                    String date = view.dateEntery();
                    serv.loadOrders(date);
                    List<Orders> order = serv.displasyOrder(date);
                    view.showOrder(order);
//                    for (Orders orderNow : order) {
//                        System.out.println(orderNow.getArea());
//                    }

                    break;
                case 2:
                    
                    Orders userOrder = view.makeNewOrder();
                    
                    serv.addOrder(userOrder);
                    comitOrNot();
                    break;

                case 3:
                    editOrder();
                    comitOrNot();
                    break;

                case 4:

                    removeOrder();
                    break;

                case 5:
                    comitOrNot();
                    break;

                case 6:
                    keepRuning = false;
                    view.displayExitMessage();
                    break;

                default:
                    unknownCommand();

            }
        }

    }

    public void editOrder() {
        String date = view.dateEntery();

        int orderNum = view.OrderNum();
        Orders orderToEdit = serv.editOrder(date, orderNum);
        Orders updaterOrders = view.newEditedOrder(orderToEdit);

    }

    public int orderNum(int ordNum) {
        ordNum = view.OrderNum();
        return ordNum;
    }

    public void removeOrder() {
        String date = view.dateEntery();

        int orderNum = view.OrderNum();
        serv.removeOrder(date, orderNum);

    }

    public void comitOrNot() {

        

        int userChoice = view.commit();
        switch (userChoice) {
            case 1:
                
                serv.saveOrder();
                view.SuccessMessage();
                break;

            case 2:
                view.returnToMainMenu();

                break;

        }
    }
    
   

    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

}
