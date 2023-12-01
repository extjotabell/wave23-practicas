package org.ejercicio.ejerciciodos.modelo.impl;

public class LibroPDF extends Documento{
    int cantidadDePaginas;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(String id, int cantidadDePaginas, String autor, String titulo, String genero) {
        super(id);
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
