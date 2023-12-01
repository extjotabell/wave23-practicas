package org.example;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MUU!");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba!");
    }
}
