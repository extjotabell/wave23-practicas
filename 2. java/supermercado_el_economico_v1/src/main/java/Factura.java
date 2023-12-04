import java.util.List;

public class Factura {
    // Atributos
    private Cliente cliente;
    private List<Item> items;
    private double total;

    // Constructor
    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        calcularTotal();
    }

    // Getters y Setters
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
        calcularTotal();
    }

    public double getTotal() {
        return total;
    }

    // Métodos
    public void calcularTotal() {
        this.total = items.stream().mapToDouble(Item::calcularSubtotal).sum();
    }
}
