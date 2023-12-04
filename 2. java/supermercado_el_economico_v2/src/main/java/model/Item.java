package model;

public class Item {
    private static int codigoCounter = 0;

    private final int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Item(String nombre, int cantidad, double precio) {
        this.codigo = ++codigoCounter;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcularSubtotal() {
        return cantidad * precio;
    }
}
