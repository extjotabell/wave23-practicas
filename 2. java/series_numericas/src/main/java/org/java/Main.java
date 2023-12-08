package org.java;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba serie de 2");
        SerieDeDos serieDos = new SerieDeDos();
        System.out.println(serieDos.getNextValor());
        System.out.println(serieDos.getNextValor());
        serieDos.resetSeries();
        System.out.println("reset valor");
        System.out.println(serieDos.valor);
        System.out.println("valor inicializado en 1");
        serieDos.initializeValor(new BigInteger("1"));
        System.out.println(serieDos.getNextValor());
        System.out.println(serieDos.getNextValor());

        System.out.println("\nPrueba serie de 3");

        SerieDeTres serieTres = new SerieDeTres();

        System.out.println(serieTres.getNextValor());
        System.out.println(serieTres.getNextValor());

    }
}