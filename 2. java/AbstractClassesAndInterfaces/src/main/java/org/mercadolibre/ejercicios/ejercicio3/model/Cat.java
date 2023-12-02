package org.mercadolibre.ejercicios.ejercicio3.model;

public class Cat extends Animal implements ICarnivorous{
    @Override
    public void makeSound() {
        System.out.println("Miau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Comiendo carne");
    }
}
