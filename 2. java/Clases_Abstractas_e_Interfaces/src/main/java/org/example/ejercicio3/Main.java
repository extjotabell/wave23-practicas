package org.example.ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gato michi = new Gato();
        Perro slinky = new Perro();
        Vaca lola = new Vaca();

        michi.emitirSonido();
        michi.comerCarne();
        System.out.println();

        slinky.emitirSonido();
        slinky.comerCarne();
        System.out.println();

        lola.emitirSonido();
        lola.comerHierba();
        System.out.println();
    }
}
