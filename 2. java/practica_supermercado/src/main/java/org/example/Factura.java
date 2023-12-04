package org.example;

import java.util.Map;

public class Factura {
    private static int nextId;
    private final int id;
    private Cliente cliente;
    private Map<Producto, Integer> productos;
    private Double costoTotal;

    public Factura(Cliente cliente, Map<Producto, Integer> productos) {
        this.id = ++ nextId;
        this.cliente = cliente;
        this.productos = productos;
        costoTotal = calcularCosto(productos);
    }

    public int getId() { return id; }

    public Cliente getCliente() {
        return cliente;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    private static Double calcularCosto(Map<Producto, Integer> productos) {
        return productos.entrySet().stream().
                mapToDouble(entry -> entry.getKey().getCosto() * entry.getValue()).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
