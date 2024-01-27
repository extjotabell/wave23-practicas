package org.example.ejercicio2;

public class LibroPDF implements Imprimible{
    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println(this.toString());
        System.out.println();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LibroPDF: ");
        sb.append("cantidadDePaginas=").append(cantidadDePaginas);
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        return sb.toString();
    }
}
