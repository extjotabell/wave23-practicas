package practica.Imprenta;

public class LibroPDF extends Documento {
    private int cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo libro...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Libro en PDF:\n" +
                "Cantidad de páginas: " + cantPaginas + "\n" +
                "Nombre de autor: " + nombreAutor + "\n" +
                "Título: " + titulo + "\n" +
                "Género: " + genero;
    }
}
