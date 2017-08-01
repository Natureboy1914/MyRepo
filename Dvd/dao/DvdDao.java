/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.dao;

import Dvd.dto.Dvd;
import java.util.List;

/**
 *
 * @author Olayinka
 */
public interface DvdDao {
    	    
	    
	    Dvd addDvd(String dvdId, Dvd dvd);
	     throws DvdDaoException;
	   
	    List<Dvd> getAllDvd();
             throws DvdDaoException;
	    
	   
            Dvd getDvd(String dvdId);
	    throws DvdDaoException;
	    
	    Dvd removeDvd(String dvdId);
            throws DvdDaoException;
	}

