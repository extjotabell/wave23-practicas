package meli.bootcamp.ej10.prototipo;

public class Serie3 extends Prototipo<Double> {

  @Override
  public Double siguiente() {
    this.valorActual += (Double) 3.0;
    return this.valorActual;
  }

}
