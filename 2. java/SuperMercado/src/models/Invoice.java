package models;

import java.util.List;
import java.util.Map;

public class Invoice {
    private Customer customer;
    private Map<Product, Integer> products;
    private double total;

    public Invoice(Customer customer, Map<Product, Integer> products) {
        this.customer = customer;
        this.products = products;
        calculateTotal();
        updateQuantity(products);
    }

    private void updateQuantity(Map<Product, Integer> products){
        for(Map.Entry<Product, Integer> entry: products.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setQuantity(product.getQuantity() - quantity);
        }
    }

    private void calculateTotal() {
        double total = 0;
        for(Map.Entry<Product, Integer> entry: products.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getUnitCost()*quantity;
        }
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
