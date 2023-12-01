package meli.bootcamp.ej7.imprimible;

public class InformeImpl implements IImprimible {
  private String texto;
  private int cantidadPaginas;
  private String autor;
  private String revisor;

  public InformeImpl(String texto, int cantidadPaginas, String autor, String revisor) {
    this.texto = texto;
    this.cantidadPaginas = cantidadPaginas;
    this.autor = autor;
    this.revisor = revisor;
  }

  @Override
  public void imprimir() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return "texto= " + texto + ", cantidadPaginas= " + cantidadPaginas + ", autor= " + autor + ", revisor= "
        + revisor;
  }

}
