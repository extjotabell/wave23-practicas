package org.example.Ej3;

public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();
    }
}
