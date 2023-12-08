package com.example.covid.entities;

public class Sintoma {
    private String codigo;
    private String nombre;
    private Gravedad gravedad;

    public Sintoma(String codigo, String nombre, Gravedad gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }
}
