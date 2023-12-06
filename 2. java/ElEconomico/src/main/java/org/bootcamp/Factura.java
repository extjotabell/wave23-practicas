package org.bootcamp;

import java.util.List;

public class Factura {

    protected Long numero_factura;
    protected Cliente cliente;
    protected List<Item> items;
    protected double total;

    public Factura(Long numero_factura, Cliente cliente, List<Item> items, double total) {
        this.numero_factura = numero_factura;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Long getNumero_factura() {
        return numero_factura;
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
                "numero_factura=" + numero_factura +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
