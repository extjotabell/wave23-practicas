package org.example.modelo;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
