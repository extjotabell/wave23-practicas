package models;

public class Product {
    private String code;
    private String name;
    private int quantity;
    private int unitCost;

    public Product(String code, String nombre, int quantity, int unitCost) {
        this.code = code;
        this.name = nombre;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }
}
