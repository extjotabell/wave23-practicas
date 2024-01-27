package org.example;

public abstract class Prototipo {
    public void setValorActual(Number valorActual) {
        this.valorActual = valorActual;
    }

    private Number valorActual;

    private Number valorInicial;

    public Prototipo(Number valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public Number getValorActual(){
        return this.valorActual;
    };

    public void reiniciarSerie(){
        this.valorActual = this.valorInicial;
    };

    public void resetValorInicial(Number valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract Number getSiguienteValor();
}
