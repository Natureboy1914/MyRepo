/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Taxs;

/**
 *
 * @author Olayinka
 */
public interface TaxDao {
    Taxs getTax(String stateName);
}
