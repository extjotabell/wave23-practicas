package org.example;

public class Vaca extends Animal implements IHervivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierva() {
        return "Comiendo pasto";
    }
}
