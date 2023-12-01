package main;

public class Vaca extends Animal implements IHerviboro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUU");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La " + this.getClass().getSimpleName().toLowerCase() + " come pasto");
    }
}
