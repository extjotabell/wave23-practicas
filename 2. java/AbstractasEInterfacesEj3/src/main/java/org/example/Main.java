package org.example;

import org.example.modelo.Animal;
import org.example.modelo.Gato;
import org.example.modelo.Perro;
import org.example.modelo.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        perro.comer();

        gato.emitirSonido();
        gato.comer();

        vaca.emitirSonido();
        vaca.comer();

        //Propuesta Extra
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }
}