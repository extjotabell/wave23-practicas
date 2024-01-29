package org.example;

public class Vaca extends Animal implements Hervivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
}
