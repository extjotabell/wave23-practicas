package org.example;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne";
    }

}
