package org.example;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro("Greta");
        System.out.println(perro.emitirSonido());

        Animal gato = new Gato("Tomy");
        gato.emitirSonido();
        System.out.println(gato.emitirSonido());

        Animal vaca = new Vaca("Lechera");
        vaca.emitirSonido();
        System.out.println(vaca.emitirSonido());

        perro.comer();
        vaca.comer();
        gato.comer();
    }
}