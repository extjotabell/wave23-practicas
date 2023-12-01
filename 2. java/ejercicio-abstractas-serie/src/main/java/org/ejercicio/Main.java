package org.ejercicio;

import org.ejercicio.model.SerieDosInteger;
import org.ejercicio.model.SerieTresDouble;

public class Main {
    public static void main(String[] args) {

        System.out.println("Serie de 2 Integer, valor inicial 5, primeros 10 numeros:");
        SerieDosInteger serieDos = new SerieDosInteger(5);
        serieDos.mostrarRango(10);

        System.out.println();

        System.out.println("Serie de 3 Double, valor inicial 2.7, primeros 15 numeros:");
        SerieTresDouble serieTres = new SerieTresDouble(2.7);
        serieTres.mostrarRango(15);

    }
}