/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import static Vm.Dao.VmDaoFileImpl.VENDINGITEMS_FILE;
import Vm.Dto.VItems;
import static java.io.FileDescriptor.out;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olayinka
 * 
 * 
 */
public interface VmAuditDao{
    
    public void writeAuditEntry(String entry) throws DaoException ;
          
       
    
}
 
  
   
    

