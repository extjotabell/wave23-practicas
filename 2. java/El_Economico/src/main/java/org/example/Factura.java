package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura implements Model {
    private static Integer proximoId = 0;
    Cliente cliente;
    String id;
    Double totalCompra;
    List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.totalCompra = items.stream().mapToDouble(Item::getPrecio).sum();
        this.id = String.valueOf(proximoId) ;
        this.items = new ArrayList<>(items);

        proximoId++;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Factura");
        sb.append("\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Items: ").append("\n").append(items).append('\n');
        sb.append("Total Compra: $").append(totalCompra);
        return sb.toString();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
