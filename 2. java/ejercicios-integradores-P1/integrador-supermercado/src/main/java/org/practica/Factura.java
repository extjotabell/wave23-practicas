package org.practica;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalFactura;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalFactura = calcularTotalFactura();
    }

    private double calcularTotalFactura() {
        return items.stream().map(i -> i.getCantidadComprada() * i.getCostoUnitario()).mapToDouble(Double::doubleValue).sum();
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

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public double getTotalFactura() {
        return totalFactura;
    }
}
