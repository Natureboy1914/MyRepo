/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author apprentice
 */
public class OrderAuditDaoStubImpl implements OrderAuditDao {
    
    public static String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws DaoException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE,true));
        } catch (IOException e) {
            System.out.println("Error");
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
         
    
}
