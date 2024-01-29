package com.example.Covid19.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Sintoma {
    private Integer codigo;
    private String nombre;
    private Integer nivelDeGravedad;

    static final public List<Sintoma> sintomas = new ArrayList<>();

    static {
        sintomas.add(new Sintoma(1, "Dolor de cabeza", 1));
        sintomas.add(new Sintoma(2,"Dolor de estomago", 1));
        sintomas.add(new Sintoma(3, "Tos", 2));
        sintomas.add(new Sintoma(4, "Fiebre", 2));
        sintomas.add(new Sintoma(5, "Dificultad para respirar", 3));
    }
    public Sintoma(Integer codigo, String nombre, Integer nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(Integer nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
