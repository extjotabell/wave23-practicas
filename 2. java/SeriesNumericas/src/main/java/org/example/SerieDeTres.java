package org.example;

public class SerieDeTres extends Prototipo{

    private final Number modificador = 3;

    public SerieDeTres(Number valorInicial) {
        super(valorInicial);
    }

    public Number getSiguienteValor(){
        this.setValorActual(getValorActual().intValue() + modificador.intValue());
        return this.getValorActual();
    };
}
