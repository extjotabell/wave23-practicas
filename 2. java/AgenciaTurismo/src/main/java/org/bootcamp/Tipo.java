package org.bootcamp;

public enum Tipo {

    HOTEL("Hotel"),
    BOLETO("Boleto"),
    COMIDA("Comida"),
    TRANSPORTE("Transporte");

    protected String tipo;

    Tipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

}
