package org.example.Models;

import java.util.List;

public class Factura implements Model {
    private Cliente cliente;
    private List<Item> items;
    private double total;
    private String id;


    public Factura(String id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream().mapToDouble(Item::getTotal).sum();
    }

    public String getId() {
        return id;
    }

    public void setIdFactura(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                ", idFactura='" + id + '\'' +
                '}';
    }


}
