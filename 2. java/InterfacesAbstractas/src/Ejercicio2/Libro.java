package Ejercicio2;

public class Libro implements Imprimir{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libro(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir(){
        System.out.println("Detalles del Libro: \n" +
                "Cantidad de Paginas: " + cantidadPaginas + '\n' +
                "Nombre del Autor: " + nombreAutor + '\n' +
                "Título: '" + titulo + '\'' + '\n' +
                "Género: '" + genero + '\'' );
    }
}
