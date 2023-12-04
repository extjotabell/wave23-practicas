package org.example.modelo;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private Double total;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    private void calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
