package org.example;

public abstract class Prototipo<T extends Number> {

    protected T valor;
    protected T valorSecuencial;

    public Prototipo(T valorSecuencial){
        this.valorSecuencial = valorSecuencial;
    }

    public abstract T generarSiguiente();

    public abstract void reiniciarValor();

    public abstract void establecerValorInicial(T valorInicial);
}
