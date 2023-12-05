package org.bootcamp;

public class Libro implements IDocumento{

    protected Autor autor;
    protected String nombre, genero;
    protected int cantidadPaginas;

    public Libro(Autor autor, String nombre, String genero, int cantidadPaginas) {
        this.autor = autor;
        this.nombre = nombre;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor=" + autor +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }

}
