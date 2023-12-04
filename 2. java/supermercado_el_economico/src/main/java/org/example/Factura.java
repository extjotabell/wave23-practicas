package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private  double total;

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = this.totalCompra();
    }

    private double totalCompra(){
        if((long) items.size() > 0){
             return items.stream().mapToDouble(Item::getCosto).sum();
        }

        return 0.0;
    }
}
