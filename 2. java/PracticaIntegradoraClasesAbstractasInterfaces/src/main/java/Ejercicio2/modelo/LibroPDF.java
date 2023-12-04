package org.example.modelo;

public class LibroPDF implements Imprimible{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro PDF:");
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println();
    }
}
