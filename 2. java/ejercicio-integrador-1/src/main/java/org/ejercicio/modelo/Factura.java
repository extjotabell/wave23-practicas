package org.ejercicio.modelo;

import java.util.List;
public class Factura {

    private Cliente comprador;
    private List<Item> items;

    private double totalCompra;

    public Factura(Cliente comprador, List<Item> items, double totalCompra) {
        this.comprador = comprador;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
