package org.ejercicio.modelo;

public class Hotel implements IServicio {
    protected IServicio iServicio;
    private String nombre;
    private int estrellas;
    private String descripcion;
    private Double costo;

    public Hotel(IServicio iServicio, String nombre, int estrellas, String descripcion, Double costo) {
        this.iServicio = iServicio;
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "iServicio=" + iServicio +
                ", nombre='" + nombre + '\'' +
                ", estrellas=" + estrellas +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public String obtenerDescripcion() {
        return this.iServicio.obtenerDescripcion() + "\n Nombre hotel: " + this.nombre + "\n Descripcion hotel: " + this.descripcion + "\n Estrellas hotel: " + this.estrellas + "\n\n";
    }

    @Override
    public Double obtenerCosto() {
        return this.iServicio.obtenerCosto() + this.costo;
    }

    @Override
    public String servicios() {
        return this.iServicio.servicios() + " Hotel";
    }


}