package org.example;

import java.util.Map;

public class Factura {
    private final Cliente cliente;
    private final Map<Producto, Integer> productos;
    private final Double costoTotal;

    public Factura(Cliente cliente, Map<Producto, Integer> productos) {
        this.cliente = cliente;
        this.productos = productos;
        costoTotal = calcularCosto(productos);
    }

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
        return productos.keySet().stream().mapToDouble(Producto::getCosto).sum();
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
