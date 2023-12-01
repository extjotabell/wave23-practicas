package org.ejercicio.model;

public class SerieTresDouble extends Serie<Double> {


    public SerieTresDouble(){
        super();
        this.valorInicial = 3.0;
        this.valorActual = 3.0;
    }
    public SerieTresDouble(Double valorInicial) {
        super(valorInicial);
        this.valorActual = valorInicial;
    }
    @Override
    public Double valorSiguiente() {
        valorActual = valorActual + 3.0;
        return valorActual;
    }
}
