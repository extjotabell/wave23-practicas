package main;

import java.util.*;

public class Factura {
    private Supermercado sm;
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Supermercado sm, Cliente cliente, List<Item> items) {
        if (!sm.esCliente(cliente)) {
            System.out.println("El cliente es nuevo, se agrega a la base de datos del supermercado");
            sm.agregarCliente(cliente);
        }

        this.sm = sm;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = items.stream().mapToDouble(Item::getPrecio).sum();
    }

    public double getTotalCompra() {
        return this.totalCompra;
    }
}
