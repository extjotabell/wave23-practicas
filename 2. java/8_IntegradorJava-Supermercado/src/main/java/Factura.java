import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Producto> listaProductos;
    private double totalCompra;

    public Factura(Cliente cliente, double totalCompra) {
        this.cliente = cliente;
        this.totalCompra = totalCompra;
        this.listaProductos = new ArrayList<>();
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
}
