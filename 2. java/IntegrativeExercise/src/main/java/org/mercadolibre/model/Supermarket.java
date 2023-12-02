package org.mercadolibre.model;

import java.util.List;

public class Supermarket {

    private List<Customer> customers;
    private List<Product> products;
    private String name;

    public Supermarket(List<Customer> customers, List<Product> products, String name) {
        this.customers = customers;
        this.products = products;
        this.name = name;
    }

    public void getCustomerByDni(String dni) {
        customers.stream()
                .filter(customer -> customer.getDni().contains(dni))
                .findFirst()
                .ifPresentOrElse(
                        customer -> System.out.println("Cliente encontrado: " + customer),
                        () -> System.out.println("El cliente no existe")
                );
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
