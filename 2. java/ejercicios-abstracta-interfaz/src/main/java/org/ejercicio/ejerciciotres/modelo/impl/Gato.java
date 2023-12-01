package org.ejercicio.ejerciciotres.modelo.impl;

import org.ejercicio.ejerciciotres.modelo.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("MIAU!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

}
