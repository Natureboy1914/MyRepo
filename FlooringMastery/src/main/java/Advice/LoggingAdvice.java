/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Advice;

import FloorM.dao.OrderAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author apprentice
 */
public class LoggingAdvice {
    OrderAuditDao auditDao;
    
    public LoggingAdvice(OrderAuditDao auditDao){
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
