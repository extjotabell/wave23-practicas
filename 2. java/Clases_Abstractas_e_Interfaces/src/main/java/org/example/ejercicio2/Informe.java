package org.example.ejercicio2;

public class Informe implements Imprimible{
    private int longitud;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Informe: ");
        sb.append("longitud=").append(longitud);
        sb.append(", cantidadDePaginas=").append(cantidadDePaginas);
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", revisor='").append(revisor).append('\'');
        return sb.toString();
    }

    public Informe(int longitud, int cantidadDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimirDocumento() {
        System.out.println(this.toString());
        System.out.println();
    }
}
