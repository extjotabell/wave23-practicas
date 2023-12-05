package org.example.Modelo;

import java.util.List;

public class Factura {

    private String codigo;
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(String codigo, Cliente cliente, List<Item> items, double totalCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "\n" +
                "codigo: " + codigo + '\n' +
                "Cliente: " + cliente.toString() + '\n' +
                "Items: " + items.toString() + '\n' +
                "Total Compra: " + totalCompra +
                '\n';
    }
}
