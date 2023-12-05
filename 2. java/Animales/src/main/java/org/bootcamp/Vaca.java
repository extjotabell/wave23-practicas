package org.bootcamp;

public class Vaca extends Animal<Animal> implements IHerbivoro{

    @Override
    public String emitirSonido() {
        return "Muuu";
    }

    @Override
    public void comerAnimal(Animal animal) {
        super.comerAnimal(animal);
    }

    @Override
    public String toString() {
        return "Vaca{}";
    }

}
