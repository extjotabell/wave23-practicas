package org.example;

import java.util.List;

public class Expense {
    private Client client;
    private List<Product> products;
    private Double totalPurchase;

    public Expense(Client client, List<Product> products, Double totalPurchase) {
        this.client = client;
        this.products = products;
        this.totalPurchase = totalPurchase;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "client=" + client +
                ", products=" + products +
                ", totalPurchase=" + totalPurchase +
                '}';
    }
}
