package main;

public class Reserva {
    private String nombre;
    private double precio;

    public Reserva(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }

}
