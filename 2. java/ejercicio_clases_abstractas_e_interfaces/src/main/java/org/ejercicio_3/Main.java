package org.ejercicio_3;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = List.of(new Gato(false, true),
                new Perro(false, true),
                new Vaca(true, false)
        );

        Animal.hacerSonido(animales);
        System.out.println();
        Animal.comerAnimal(animales);
    }
}
