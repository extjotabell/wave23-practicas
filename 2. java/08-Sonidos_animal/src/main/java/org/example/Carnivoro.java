package org.example;

public interface Carnivoro {
    default void comerCarne(){
        System.out.println("Comiendo carne");
    }

    default void comerAnimal(Animal animal){
        System.out.println(this.getClass().getSimpleName() + " come a " + animal.getClass().getSimpleName());
    }

    void emitirSonido();
}