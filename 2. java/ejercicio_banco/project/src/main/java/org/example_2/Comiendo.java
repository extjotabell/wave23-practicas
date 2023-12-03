package org.example_2;

import java.util.Objects;

public interface Comiendo {
    default void comerAnimal(Animal animal) {
        if (animal instanceof Perro || animal instanceof Gato){
            System.out.println("Come carne");
        }
        else {System.out.println("Come carne");}
    }
}
