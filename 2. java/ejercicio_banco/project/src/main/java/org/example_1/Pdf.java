package org.example_1;

public class Pdf implements Imprimible{

    private int cantidadDePaginas;
    private String titulo;
    private String genero;

    public Pdf(int cantidadDePaginas, String titulo, String genero, Persona persona) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.titulo = titulo;
        this.genero = genero;
        this.persona = persona;
    }

    private Persona persona;

    @Override
    public String imprimiendo(){
        return persona.toString() + titulo + genero + cantidadDePaginas;
    }
}
