/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorM.dto;

import java.math.BigDecimal;

/**
 *
 * @author Olayinka
 */
public class Products {
    private String productType;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the costPerSquareFoot
     */
    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    /**
     * @param costPerSquareFoot the costPerSquareFoot to set
     */
    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    /**
     * @return the laborCostPerSquareFoot
     */
    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    /**
     * @param laborCostPerSquareFoot the laborCostPerSquareFoot to set
     */
    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }
    
}
