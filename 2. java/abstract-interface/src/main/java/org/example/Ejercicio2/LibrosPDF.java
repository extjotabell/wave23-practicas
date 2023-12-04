package org.example.Ejercicio2;

public class LibrosPDF {
    int paginas;
    String autor;
    String titulo;
    String genero;

    @Override
    public String toString() {
        return "LibrosPDF{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
