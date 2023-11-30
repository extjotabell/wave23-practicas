package org.ejercicios;

import org.ejercicios.modelo.Persona;

public class Main {
    public static void main(String[] args) {

        Persona martin = new Persona();
        Persona hernan = new Persona("Hernan",22,"123456789");
        Persona zuly = new Persona("Zuly",23,"987654321",60.3,1.55);

        //No sería posible crear una persona con solo su nombre y edad porque no tenemos un constructor para ello.

        System.out.println(zuly);
    }
}