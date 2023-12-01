package org.example;

import java.util.Map;

public class Factura {
    private static int nextId;
    private final int id;
    private final Cliente cliente;
    private final Map<Producto, Integer> productos;
    private final Double costoTotal;

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
