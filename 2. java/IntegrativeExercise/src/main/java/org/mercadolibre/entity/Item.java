package org.mercadolibre.entity;

/**
 * Represents an item with a code, name, quantity, and unit cost.
 */
public class  Item {
    private String code;
    private String name;
    private int quantities;
    private double unitCost;

    public Item(String code, String name, int quantities, double unitCost) {
        this.code = code;
        this.name = name;
        this.quantities = quantities;
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

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return
                "codigo:'" + code + '\'' +
                        ", nombre:'" + name + '\'' +
                        ", cantidad:" + quantities +
                        ", costo unitario:" + unitCost;
    }
}
