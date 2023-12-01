package org.example;

public class Libro extends Documento {
    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public Libro(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro{" +
                "texto='" + genero + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + titulo + '\'' +
                '}');
    }
}
