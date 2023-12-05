package org.bootcamp;

public class Perro extends Animal<Animal> implements ICarnivoro{

    @Override
    public String emitirSonido() {
        return "Guau";
    }

    @Override
    public void comerAnimal(Animal animal) {
        super.comerAnimal(animal);
    }

    @Override
    public String toString() {
        return "Perro{}";
    }

}
