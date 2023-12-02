package org.example;

import java.util.Random;

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;

    private double montoMenores;
    private double montoMayores;

    public Categoria(String nombre, String descripcion, double montoMenores, double montoMayores) {
        this.id = new Random().nextInt(1000);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMenores = montoMenores;
        this.montoMayores = montoMayores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nCategoria: " + nombre + '\'' +
                ", \nDescripcion='" + descripcion;
    }
}
