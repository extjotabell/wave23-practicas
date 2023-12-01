package org.example.modelo;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private double total;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
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
        this.total = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
