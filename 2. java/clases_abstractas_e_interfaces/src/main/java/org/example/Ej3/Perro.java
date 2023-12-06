package org.example.Ej3;

public class Perro extends Animal implements ICarnivoro{

    @Override
    void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
