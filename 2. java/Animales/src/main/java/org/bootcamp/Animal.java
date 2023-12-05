package org.bootcamp;

public abstract class Animal<A> {

    public abstract String emitirSonido();

    public void comerAnimal(A animal){
        System.out.println("Comiendo animal: " + animal);
    }

}
