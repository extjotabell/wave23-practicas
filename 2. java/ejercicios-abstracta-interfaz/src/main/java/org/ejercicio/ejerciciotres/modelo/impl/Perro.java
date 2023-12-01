package org.ejercicio.ejerciciotres.modelo.impl;

import org.ejercicio.ejerciciotres.modelo.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("GUAU!");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

}
