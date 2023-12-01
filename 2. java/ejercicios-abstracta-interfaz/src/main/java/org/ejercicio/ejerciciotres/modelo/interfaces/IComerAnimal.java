package org.ejercicio.ejerciciotres.modelo.interfaces;

import org.ejercicio.ejerciciotres.modelo.impl.Animal;

public interface IComerAnimal {

    static void comerAnimal(Animal animal){
        animal.comer();
    }
}
