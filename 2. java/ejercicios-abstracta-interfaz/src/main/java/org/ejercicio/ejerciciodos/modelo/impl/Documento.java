package org.ejercicio.ejerciciodos.modelo.impl;

import org.ejercicio.ejerciciodos.modelo.interfaces.IImprimible;

public abstract class Documento implements IImprimible {
    String id;

    public Documento(String id) {
        this.id = id;
    }

}
