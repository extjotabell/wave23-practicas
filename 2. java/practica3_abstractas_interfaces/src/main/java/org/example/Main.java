package org.example;

public class Main {
    public static void main(String[] args) {
        Animal animalPerro = new Perro();
        Animal animalGato = new Gato();
        Animal animalVaca = new Vaca();

        animalPerro.emitirSonido();
        animalGato.emitirSonido();
        animalVaca.emitirSonido();

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();
    }
}
