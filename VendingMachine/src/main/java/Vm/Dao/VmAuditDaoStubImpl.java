/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vm.Dao;

import Vm.Dto.VItems;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olayinka
 */
public class VmAuditDaoStubImpl implements VmAuditDao {

    public static String AUDIT_FILE = "auditDao.txt";

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
