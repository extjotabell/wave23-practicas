package org.bootcamp;

public class Informe implements IDocumento{

    protected Autor autor;
    protected int longitud, cantidadPaginas;
    protected Revisor revisor;

    public Informe(Autor autor, int longitud, int cantidadPaginas, Revisor revisor) {
        this.autor = autor;
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.revisor = revisor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "autor=" + autor +
                ", longitud=" + longitud +
                ", cantidadPaginas=" + cantidadPaginas +
                ", revisor=" + revisor +
                '}';
    }

}
