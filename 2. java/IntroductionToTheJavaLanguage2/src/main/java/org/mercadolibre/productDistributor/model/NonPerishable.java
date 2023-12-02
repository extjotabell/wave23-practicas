package org.mercadolibre.productDistributor.model;

public class NonPerishable extends Product {

    private String type;

    public NonPerishable(String type, String name, double price) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Alimento no perecedero de tipo=" + type + "\n";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
