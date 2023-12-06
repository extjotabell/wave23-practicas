package org.example.Ej3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    void emitirSonido() {
        System.out.println("muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba.");
    }
}
