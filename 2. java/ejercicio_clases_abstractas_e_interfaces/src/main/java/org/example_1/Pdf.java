package org.example_1;

public class Pdf implements Imprimible{

    private int cantidadDePaginas;
    private String titulo;
    private String genero;

    public Pdf(Persona persona) {
        this.persona = persona;
    }

    private Persona persona;

    @Override
    public String imprimiendo(){
        return persona.toString() + titulo + genero + cantidadDePaginas;
    }
}
