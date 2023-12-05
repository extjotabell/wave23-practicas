package org.example;

public class SerieInteger extends Prototipo<Integer>{

    public SerieInteger(int valorSecuencial){
        super(valorSecuencial);
        this.valor = 0;
    }

    @Override
    public Integer generarSiguiente() {
        return this.valor + valorSecuencial;
    }

    @Override
    public void reiniciarValor() {
        this.valor = 0;
    }

    @Override
    public void establecerValorInicial(Integer valorInicial) {
        this.valor = valorInicial;
    }
}
