package com.example.covid19.models;

public class Sintoma {
    private String codigo;
    private String nombre;
    private NivelesGravedad nivelDeGravedad;

    public Sintoma(String codigo, String nombre, NivelesGravedad nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelesGravedad getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(NivelesGravedad nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
