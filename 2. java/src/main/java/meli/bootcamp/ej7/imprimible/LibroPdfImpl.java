package meli.bootcamp.ej7.imprimible;

public class LibroPdfImpl implements IImprimible {
  private int cantidadPaginas;
  private String nombreAutor;
  private String titulo;
  private String genero;

  public LibroPdfImpl(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
    this.cantidadPaginas = cantidadPaginas;
    this.nombreAutor = nombreAutor;
    this.titulo = titulo;
    this.genero = genero;
  }

  @Override
  public void imprimir() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return "cantidadPaginas= " + cantidadPaginas + ", nombreAutor= " + nombreAutor + ", titulo= " + titulo
        + ", genero= " + genero;
  }

}
