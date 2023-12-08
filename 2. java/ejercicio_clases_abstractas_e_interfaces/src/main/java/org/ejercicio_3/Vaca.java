package org.ejercicio_3;

public class Vaca extends Animal implements IComerHierva {
    public Vaca(boolean hervivoro, boolean carnivoro) {
        super(hervivoro, carnivoro);
    }

    public void emitirSonido() {
        System.out.println("muuuu");
    }

    public void comerHierva() {
        System.out.println("Vaca come hierva");
    }
}