package org.example.modelo;

public class Producto {
    private static int codigo = 0;
    private String nombre;
    private int cantidad;
    private Double precio;

    public Producto(String nombre, int cantidad, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        codigo++;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
