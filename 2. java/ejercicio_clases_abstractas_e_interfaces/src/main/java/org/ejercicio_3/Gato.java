package org.ejercicio_3;

public class Gato extends Animal implements IComerCarne {
    public Gato(boolean hervivoro, boolean carnivoro) {
        super(hervivoro, carnivoro);
    }

    public void emitirSonido() {
        System.out.println("miau");
    }

    public void comerCarne() {
        System.out.println("Gato come carne");
    }
}
