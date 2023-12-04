package org.example;

public class Campera extends Prenda{

    String nombre, color;
    public Campera(String marca, String modelo, String nombre, String color) {
        super(marca, modelo);
        this.nombre = nombre;
        this.color = color;
    }
}
