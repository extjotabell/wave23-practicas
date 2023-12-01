package org.example;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne!");
    }
}
