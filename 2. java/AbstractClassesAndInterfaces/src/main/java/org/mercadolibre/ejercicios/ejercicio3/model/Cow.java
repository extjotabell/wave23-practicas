package org.mercadolibre.ejercicios.ejercicio3.model;

public class Cow extends Animal implements IHerbivorous{
    @Override
    public void makeSound() {
        System.out.println("Muuu");
    }

    @Override
    public void eatGrass() {
        System.out.println("Comiendo hierba");
    }
}
