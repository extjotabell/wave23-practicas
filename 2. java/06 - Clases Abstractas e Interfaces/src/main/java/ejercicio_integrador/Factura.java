package ejercicio_integrador;

import java.util.List;
import java.util.Random;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.id = new Random().nextInt(1000);;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = calcularTotal();
    }

    private double calcularTotal(){
        return items.stream()
                .mapToDouble(Item::getSubtotal)
                .sum();
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
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    @Override
    public String toString() {
        String itemsLista = "";
        for (Item item : this.items) {
            itemsLista += "\n" + item;
        }

        return "Factura Nª " +  id +
                "\nCliente:" + cliente +
                "\nDetalle: " + itemsLista +
                "\nTotal: " + totalCompra;
    }
}
