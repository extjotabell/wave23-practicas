package org.example;

public class Main {
    public static void main(String[] args) {
        Animal vaca = new Vaca();
        Vaca vaca2 = new Vaca();
        vaca.emitirSonido();
        System.out.println(vaca2.comerHierva());
    }
}