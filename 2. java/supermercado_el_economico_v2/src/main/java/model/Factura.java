package model;

import java.util.List;

public class Factura {
    private static int idCounter = 0;

    private final int id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.id = ++idCounter;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public int getId() {
        return id;
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
        this.total = calcularTotal();
    }

    public double getTotal() {
        return total;
    }

    public double calcularTotal() {
        return items.stream()
            .mapToDouble(Item::getPrecio)
            .sum();
    }
}
