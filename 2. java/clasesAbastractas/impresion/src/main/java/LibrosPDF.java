public class LibrosPDF implements Imprimible {

   int cantidadPaginas;
   String nombreAutor;
   String titulo;

   String genero;

   public LibrosPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
      this.cantidadPaginas = cantidadPaginas;
      this.nombreAutor = nombreAutor;
      this.titulo = titulo;
      this.genero = genero;
   }

   @Override
   public void imprimir() {
      System.out.println("Cantidad de páginas: " + cantidadPaginas);
      System.out.println("Nombre de autor: " + nombreAutor);
      System.out.println("Título: " + titulo);
      System.out.println("Género: " + genero);
   }
}
