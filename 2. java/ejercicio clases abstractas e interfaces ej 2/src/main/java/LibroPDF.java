public class LibroPDF extends Documento {

    private String genero;
    private int cantidadPaginas;

    private String autor;

    private String titulo;

    public LibroPDF(String genero, int cantidadPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF{" +
                "genero='" + genero + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}');
    }
}
