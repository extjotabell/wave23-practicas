package Ejercicio2.imprimibles;

import Ejercicio2.Imprimible;

public class Libro implements Imprimible {
    private String autor;

    private String titulo;
    private String genero;
    private int cantPaginas;

    public Libro(String autor, String titulo, String genero, int cantPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantPaginas = cantPaginas;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }
}
