package org.mercadolibre.ejercicios.ejercicio3;

import org.mercadolibre.ejercicios.ejercicio3.model.Cat;
import org.mercadolibre.ejercicios.ejercicio3.model.Cow;
import org.mercadolibre.ejercicios.ejercicio3.model.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        dog.eatMeat();

        Cat cat = new Cat();
        cat.makeSound();
        cat.eatMeat();

        Cow cow = new Cow();
        cow.eatGrass();
        cow.makeSound();
    }
}
