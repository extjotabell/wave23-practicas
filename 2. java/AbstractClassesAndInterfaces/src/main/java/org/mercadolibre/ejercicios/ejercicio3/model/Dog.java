package org.mercadolibre.ejercicios.ejercicio3.model;

public class Dog extends Animal implements ICarnivorous{
    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Comiendo carne");
    }
}
