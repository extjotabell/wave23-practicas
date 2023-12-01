package org.ejercicio.ejerciciotres.modelo.impl;

import org.ejercicio.ejerciciotres.modelo.interfaces.IHervivoro;

public class Vaca extends  Animal implements IHervivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUU!");
    }

    @Override
    public void comeHierba() {
        System.out.println("La vaca come hierba");
    }

    @Override
    public void comer() {
        this.comeHierba();
    }
}
