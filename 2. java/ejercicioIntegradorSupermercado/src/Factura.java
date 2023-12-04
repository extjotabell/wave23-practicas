import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private int total;

    public Factura(Cliente cliente, List<Item> items, int total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }
}
