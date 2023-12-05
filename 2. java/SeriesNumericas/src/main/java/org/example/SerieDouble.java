package org.example;

public class SerieDouble extends Prototipo<Double> {

    public SerieDouble(double valorSecuencial){
        super(valorSecuencial);
        this.valor = 0.0;
    }

    @Override
    public Double generarSiguiente() {
        return this.valor + valorSecuencial;
    }

    @Override
    public void reiniciarValor() {
        this.valor = 0.0;
    }

    @Override
    public void establecerValorInicial(Double valorInicial) {
        this.valor = valorInicial;
    }
}
