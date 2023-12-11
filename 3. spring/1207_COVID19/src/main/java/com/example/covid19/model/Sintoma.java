package com.example.covid19.model;

import java.util.ArrayList;
import java.util.List;

public class Sintoma {

    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

    private static List<Sintoma> listaSintomas = new ArrayList<>();

    public Sintoma(String codigo, String nombre, int nivelDeGravedad) {
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

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public static List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }

    public static void agregarSintoma(Sintoma nuevoSintoma) {
        Sintoma.listaSintomas.add(nuevoSintoma);
    }
}
