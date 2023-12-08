package org.mercadolibre.entity;

import java.util.List;

/**
 * Represents an invoice associated with a customer, containing a list of items and the total amount.
 */
public class Invoice {

    private Customer customer;
    private List<Item> items;
    private Double total;

    private Integer voiceNro;

    public Invoice(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        this.total = calculateTotal();
        voiceNro++;
    }

    private double calculateTotal() {
        double total = 0;
        for(Item item: items) {
            total += item.getQuantities() * item.getUnitCost();
        }
        return total;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getVoiceNro() {
        return voiceNro;
    }

    public void setVoiceNro(int voiceNro) {
        this.voiceNro = voiceNro;
    }
}