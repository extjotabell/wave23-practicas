package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompta;

    public Factura(Cliente cliente, List<Item> items, double totalCompta) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompta = totalCompta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCompta() {
        return totalCompta;
    }
}
