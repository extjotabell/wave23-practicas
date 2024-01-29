package org.example.Models;

public class Producto implements Model {
    private double costo;
    private String nombre;
    private String codigo;

    public Producto(double costo, String nombre, String codigo) {
        this.costo = costo;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "costo=" + costo +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}