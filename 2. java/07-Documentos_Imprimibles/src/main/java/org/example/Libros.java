package org.example;

public class Libros extends Documento{
    int cantidadPaginas;
    String autor;
    String titulo;
    String genero;

    public Libros(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
        System.out.println("Numero de Paginas: " + cantidadPaginas);
    }

    @Override
    public void imprimirTipoDocumento() {

    }
}
