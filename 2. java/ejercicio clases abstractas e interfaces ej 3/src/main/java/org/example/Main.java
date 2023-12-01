package org.example;

public class Main {
    public static void main(String[] args) {
        Animal vaca = new Vaca();
        Vaca vaca2 = new Vaca();
        vaca.emitirSonido();
        System.out.println(vaca2.comerHierva());

        Animal gato = new Gato();
        Gato gato2 = new Gato();
        gato.emitirSonido();
        System.out.println(gato2.comerCarne());

        Animal perro = new Perro();
        Perro perro2 = new Perro();
        perro.emitirSonido();
        System.out.println(perro2.comerCarne());
    }
}