package org.example;

public class Product {
    private Integer code;
    private String name;
    private Integer purchasedAmount;
    private Double unitCost;

    public Product(Integer code, String name, Integer purchasedAmount, Double unitCost) {
        this.code = code;
        this.name = name;
        this.purchasedAmount = purchasedAmount;
        this.unitCost = unitCost;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", purchasedAmount=" + purchasedAmount +
                ", unitCost=" + unitCost +
                '}';
    }
}
