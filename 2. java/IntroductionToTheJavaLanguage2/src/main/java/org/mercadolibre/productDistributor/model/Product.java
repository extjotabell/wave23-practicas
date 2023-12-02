package org.mercadolibre.productDistributor.model;

public class Product {

    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double calculator(int candidateProductions){
        return price * candidateProductions;
    }

    @Override
    public String toString() {
        return "Producto: " + name + ", precio=" + price + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
