package meli.bootcamp.ej10.prototipo;

public class Serie2 extends Prototipo<Integer> {

  @Override
  public Integer siguiente() {
    this.valorActual += 2;
    return this.valorActual;
  }

}
