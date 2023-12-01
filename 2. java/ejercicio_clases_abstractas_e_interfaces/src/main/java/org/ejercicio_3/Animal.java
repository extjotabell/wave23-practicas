package org.ejercicio_3;

import java.util.List;
public abstract class Animal {
    private boolean hervivoro;
    private boolean carnivoro;

    //Tal vez hubiera sido mejor crear una interfaz de comer ...
    static void comerAnimal(List<Animal> animals) {
        for (Animal animal: animals) {
            if (animal.carnivoro) ((IComerCarne) animal).comer();
            if (animal.hervivoro) ((IComerHierva) animal).comer();
        }
    }

    static void hacerSonido(List<Animal> animals) {
        for (Animal animal: animals) {
            animal.emitirSonido();
        }
    }

    public Animal(boolean hervivoro, boolean carnivoro) {
        this.hervivoro = hervivoro;
        this.carnivoro = carnivoro;
    }

    public abstract void emitirSonido();
}
