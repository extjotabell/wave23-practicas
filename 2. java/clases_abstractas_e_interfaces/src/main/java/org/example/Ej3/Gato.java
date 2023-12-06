package org.example.Ej3;

public class Gato extends Animal implements ICarnivoro{

    @Override
    void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
