package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    static public List<Factura> facturas = new ArrayList<>();
    static void agregarFactura(Factura factura, ClienteImp clienteRep){
        Cliente cliente = factura.getCliente();
        if (cliente == null) {
            cliente = Cliente.crearCliente();
        }
        clienteRep.save(cliente);
        double totalCompra;
        totalCompra = factura.itemRep.getElements().stream().mapToDouble(Item::getCostoTotal).sum();
        factura.setTotalCompra(totalCompra);
        facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + itemRep.getElements() +
                ", totalCompra=" + totalCompra +
                '}';
    }

    private final Cliente cliente;
    private final ItemImp itemRep;
    private double totalCompra;

    public Cliente getCliente() {
        return cliente;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Factura(Cliente cliente, ItemImp itemRep) {
        this.cliente = cliente;
        this.itemRep = itemRep;
    }
}
