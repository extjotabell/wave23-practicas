package org.example;

public class Producto {
    private static int nextId;
    private final int id;
    private String nombre;
    private Double costo;

    public Producto(String nombre, Double costo) {
        this.id = ++ nextId;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
}
