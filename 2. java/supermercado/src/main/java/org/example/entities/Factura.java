package org.example.entities;

import java.util.List;

public class Factura {
    private Long id;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura() {
    }

    public Factura(Long id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    private Double calcularTotal() {
        Double result = 0.0;
        for(Item item : items) {
            result += (item.getCostoUnitario() * item.getCantidad());
        }
        return result;
    }

    @Override
    public String toString() {
        return "\nFactura N°: " + id +
                ", \ncliente: " + cliente +
                ", \nitems: " + items +
                ", \ntotal : $" + total;
    }
}