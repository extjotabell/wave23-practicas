package org.example;

public class SerieDeDos extends Prototipo{
    private final Number modificador = 2;

    public SerieDeDos(Number valorInicial) {
        super(valorInicial);
    }

    public Number getSiguienteValor(){
        this.setValorActual(getValorActual().intValue() + modificador.intValue());
        return this.getValorActual();
    };
}
