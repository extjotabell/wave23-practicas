package meli.bootcamp.ej8.animal;

public class Gato extends Animal implements ICarnivoro {

  @Override
  public void emitirSonido() {
    System.out.println("miau");
  }

  @Override
  public void comerCarne() {
    System.out.println("Gato comiendo carne...");
  }

  @Override
  public void comer() {
    this.comerCarne();
  }
}
