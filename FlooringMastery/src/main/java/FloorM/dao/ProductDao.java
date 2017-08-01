/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dao;

import FloorM.dto.Products;

/**
 *
 * @author Olayinka
 */
public interface ProductDao {
    
    Products getProduct(String productName);
    
}
