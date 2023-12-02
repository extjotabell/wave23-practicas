package org.mercadolibre.model;

import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Product> products;
    private Double totalPurchaseAmount;

    public Invoice(Customer customer, List<Product> products, Double totalPurchaseAmount) {
        this.customer = customer;
        this.products = products;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(Double totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }
}
