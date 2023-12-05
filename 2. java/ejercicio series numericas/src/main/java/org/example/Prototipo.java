package org.example;

public abstract class Prototipo <T extends Number>{
    protected T valorInicial;
    protected T valorActual;

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract T siguienteNumSerie();

    public void reiniciarSerie() {
        this.valorActual = valorInicial;
    }

    public void establecerValorInicial(T nuevoValorInicial) {
        valorInicial = nuevoValorInicial;
        valorActual = nuevoValorInicial;
    }
}
