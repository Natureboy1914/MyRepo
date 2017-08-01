/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Controller;

import VendingMachine.error.VendingEmptyInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Dao.VmDao;
import Vm.Dto.VItems;
import Vm.Service.Change;
import Vm.Service.VmService;
import Vm.Service.VmServiceImpl;
import Vm.UserIo.VmIo;
import Vm.UserIo.VmUserIoImpl;
import Vm.UserIo.VmView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public class VMController {

    private VmService service;
    private VmView View;

    public VMController(VmService service, VmView View) {
        this.service = service;
        this.View = View;
    }

    public void execute() {
        List<VItems> items = service.retieveItem();
        View.displayItemMenu(items);

        View.welcomMenu();
        BigDecimal cash = View.getCash();
        String userSelection;
        boolean keepRuning = true;
        while (keepRuning) {

            switch (View.menuSelection()) {

                case 1:
                    userSelection = retrievItemName();
                    try {
                        service.validateMoney(userSelection, cash);
                    } catch (VendingMachineExceptions e) {
                        View.displayInsufficientFundsException(e);
                    continue;
                    }

                    try {
                        service.validateInventory(service.getItem(userSelection));
                    } catch (VendingEmptyInventoryException e) {
                        View.displayInventoryException(e);
                        continue;
                    }

                    Change change = service.vend(cash, userSelection);
                    View.displayChange(change);
                    
                  service.updateItems(userSelection);
                    

                case 2:
                    keepRuning = false;
                    exitMessage();
                    break;

                default:
                    unknownCommand();

            }
        }

    }

    public String retrievItemName() {

        String userSelection = View.displayItemSelection();

        return userSelection;
    }

    public void exitMessage() {
        View.displayExitMessage();
    }
 private void unknownCommand() {
    View.displayUnknownCommandBanner();
}
}
