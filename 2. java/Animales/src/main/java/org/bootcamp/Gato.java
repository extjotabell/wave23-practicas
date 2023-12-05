package org.bootcamp;

public class Gato extends Animal<Animal> implements ICarnivoro{

    @Override
    public String emitirSonido() {
        return "Miau";
    }

    @Override
    public void comerAnimal(Animal animal) {
        super.comerAnimal(animal);
    }

    @Override
    public String toString() {
        return "Gato{}";
    }

}
