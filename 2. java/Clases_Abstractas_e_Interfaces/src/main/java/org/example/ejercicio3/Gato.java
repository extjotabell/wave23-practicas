package org.example.ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }

    @Override
    public void emitirSonido(){
        super.emitirSonido();
        System.out.println("Miau!");
    }
}
