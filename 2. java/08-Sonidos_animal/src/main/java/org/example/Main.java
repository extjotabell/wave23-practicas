package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Herviboro vaca = new Vaca();
        Carnivoro gato = new Gato();
        Carnivoro perro = new Perro();

        vaca.comerHierba();
        gato.comerCarne();
        perro.comerCarne();
        gato.comerAnimal((Animal) vaca);
        perro.comerAnimal((Animal) gato);
    }
}