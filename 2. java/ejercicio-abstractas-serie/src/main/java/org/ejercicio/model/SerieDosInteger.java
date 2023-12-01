package org.ejercicio.model;

public class SerieDosInteger extends Serie<Integer>{

    public SerieDosInteger(){
        super();
        this.valorInicial = 2;
        this.valorActual = 2;
    }
    public SerieDosInteger(Integer valorInicial) {
        super(valorInicial);
        this.valorActual = valorInicial;
    }

    @Override
    public Integer valorSiguiente() {
        valorActual = valorActual + 2;
        return valorActual;
    }



}
