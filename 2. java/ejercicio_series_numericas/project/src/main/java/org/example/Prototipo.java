package org.example;

import javax.swing.*;

public abstract class Prototipo <T extends Number> {
    protected T valor;

    public Prototipo(T valor) {
        this.valor = valor;
    }

    public abstract void nextValue();

    public abstract void resetValue();

    public abstract void setValue(Integer objeto);
}
