package org.example_1;

import java.util.SplittableRandom;

public class Informes implements Imprimible{
    private int longitud;
    private int cantidadDePaginas;

    private Persona autor;

    private String revisor;

    public Informes(int longitud, int cantidadDePaginas, Persona autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimiendo(){
        return autor.toString() + cantidadDePaginas + longitud + revisor;
    }
}
