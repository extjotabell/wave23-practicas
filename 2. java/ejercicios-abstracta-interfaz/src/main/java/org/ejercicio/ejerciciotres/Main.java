package org.ejercicio.ejerciciotres;

import org.ejercicio.ejerciciotres.modelo.impl.Gato;
import org.ejercicio.ejerciciotres.modelo.interfaces.IComerAnimal;
import org.ejercicio.ejerciciotres.modelo.impl.Perro;
import org.ejercicio.ejerciciotres.modelo.impl.Vaca;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        perro.comerCarne();
        Gato gato = new Gato();
        gato.comerCarne();
        Vaca vaca = new Vaca();
        vaca.comeHierba();

        System.out.println("-------------");
        IComerAnimal.comerAnimal(perro);
        IComerAnimal.comerAnimal(gato);
        IComerAnimal.comerAnimal(vaca);


    }
}