package model;

import java.util.ArrayList;

public class Factura {

    private String numeroFactura;
    private Cliente cliente;
    private ArrayList<Producto> listaProductos;
    private double totalCompra;

    public Factura(Cliente cliente, String numeroFactura) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.totalCompra = 0;
        this.listaProductos = new ArrayList<>();
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void agregarProducto(Producto nuevoProducto){
        this.listaProductos.add(nuevoProducto);
    }

    public double calcularTotal(){
        this.totalCompra = this.listaProductos.stream()
                .mapToDouble( p -> p.getCostoUnitario() * p.getCantidadComprada())
                .sum();
        return this.totalCompra;
    }
}
