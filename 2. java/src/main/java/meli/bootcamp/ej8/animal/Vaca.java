package meli.bootcamp.ej8.animal;

public class Vaca extends Animal implements IHerviboro {

  @Override
  public void emitirSonido() {
    System.out.println("muuu");
  }

  @Override
  public void comerHierba() {
    System.out.println("Vaca comiendo hierba...");
  }

  @Override
  public void comer() {
    this.comerHierba();
  }

}
