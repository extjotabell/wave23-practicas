package org.test;

import org.bootcamp.Gato;
import org.bootcamp.Perro;
import org.bootcamp.Vaca;

public class Main {

    public static void main(String[] args){
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println(perro.emitirSonido());
        System.out.println(gato.emitirSonido());
        System.out.println(vaca.emitirSonido());

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        perro.comerAnimal(gato);
    }

}
