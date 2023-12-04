package org.ejercicio.modelo;

import java.util.ArrayList;
import java.util.List;
public class Factura {

    private long id;
    private Cliente comprador;
    private List<Item> items;

    private double totalCompra;

    public Factura(long id, Cliente comprador, List<Item> items, double totalCompra) {
        this.comprador = comprador;
        this.items = items;
        this.totalCompra = totalCompra;
        this.id = id;
    }

    public static double calcularTotalCompra(ArrayList<Item> items){
        return items.stream().mapToDouble(i -> i.getCostoUnitario()*i.getCantidadComprada()).sum();
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "comprador=" + comprador +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
