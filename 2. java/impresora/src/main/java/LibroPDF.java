public class LibroPDF extends Documento {
    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public LibroPDF(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("----- " + imprimirTipoDoc() + " -----");

        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);

        System.out.println("Genero: " + this.genero);
        System.out.println("Cantidad de paginas: " + this.cantPaginas);
    }

    @Override
    public String imprimirTipoDoc() {
        return "Libro PDF";
    }
}
