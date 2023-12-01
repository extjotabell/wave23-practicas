package meli.bootcamp.ej10.prototipo;

public abstract class Prototipo<T extends Number> {
  private T valorInicial;
  protected T valorActual;

  public abstract T siguiente();

  public void reiniciar() {
    this.valorActual = this.valorInicial;
  }

  public void iniciar(T valorInicial) {
    this.valorActual = valorInicial;
    this.valorInicial = valorInicial;
  }
}
