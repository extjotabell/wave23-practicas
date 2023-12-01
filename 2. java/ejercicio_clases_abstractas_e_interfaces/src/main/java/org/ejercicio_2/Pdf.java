package org.ejercicio_2;

public class Pdf implements Imprimible{

    private int cantidadDePaginas;
    private String titulo;
    private String genero;

    public Pdf(int cantidadDePaginas, String titulo, String genero, Autor persona) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.titulo = titulo;
        this.genero = genero;
        this.persona = persona;
    }

    private Autor persona;

    @Override
    public String toString() {
        return "Pdf{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", persona=" + persona +
                '}';
    }

    public String imprimir() {
        return "Pdf: " + this.toString();
    }
}
