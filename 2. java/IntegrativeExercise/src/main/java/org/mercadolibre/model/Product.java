package org.mercadolibre.model;

public class Product {
    private String code;
    private String name;
    private Integer purchasedAmount;
    private Double unitCost;

    public Product(String code, String name, Integer purchasedAmount, Double unitCost) {
        this.code = code;
        this.name = name;
        this.purchasedAmount = purchasedAmount;
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPurchasedAmount() {
        return purchasedAmount;
    }

    public void setPurchasedAmount(Integer purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }
}
