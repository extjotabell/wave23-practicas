package bootcamp;

import java.util.ArrayList;
import java.util.List;

import static bootcamp.Cliente.clientes;

public class Factura {
    static public List<Factura> facturas = new ArrayList<>();
    static void agregarFactura(Factura factura){
        Cliente cliente = factura.getCliente();
        if (cliente == null) {
            cliente = Cliente.crearCliente();
        }
        clientes.add(cliente);
        double totalCompra = 0.0;
        totalCompra = factura.items.stream().mapToDouble(Item::getCostoTotal).sum();
        factura.setTotalCompra(totalCompra);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

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

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }
}
