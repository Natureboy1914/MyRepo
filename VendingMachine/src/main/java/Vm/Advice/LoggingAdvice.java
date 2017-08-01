/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Advice;

import VendingMachine.error.VendingDecrementInventoryException;
import VendingMachine.error.VendingMachineExceptions;
import Vm.Dao.DaoException;
import Vm.Dao.VmAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Olayinka
 */
public class LoggingAdvice {
    VmAuditDao auditDao;
    
    public LoggingAdvice(VmAuditDao auditDao){
        this.auditDao = auditDao;
    }
    
     public void createAuditEntry(JoinPoint jp, Exception e) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": " + e.getMessage();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (Exception ex) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
