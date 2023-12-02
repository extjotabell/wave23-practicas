package org.mercadolibre.ejercicios.ejercicio2.model;

public abstract class Document implements IPrintable {

    protected int id;

    public Document(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
