package com.example.ejercicioRepaso.entities;

public class Encript {

    private String palabra;

    private String clave;

    public Encript(String palabra, String clave) {
        this.palabra = palabra;
        this.clave = clave;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getClave() {
        return clave;
    }
}
