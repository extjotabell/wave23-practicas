package main;

public class Producto {

    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: \n" +
                "Nombre: " + this.nombre + "\n" +
                "Precio: " + this.precio + "\n";
    }

    public double calcular(int cantDeProductos) {
        return cantDeProductos * this.precio;
    }
}
