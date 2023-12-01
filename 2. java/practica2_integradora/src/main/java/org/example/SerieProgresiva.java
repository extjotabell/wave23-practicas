package org.example;

public abstract class SerieProgresiva<T extends Number> {
    private T valorInicial;
    private T valorActual;
    private T incremento;

    public SerieProgresiva(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public T getIncremento() {
        return incremento;
    }

    public T siguienteValor() {
        valorActual = sumar(valorActual, incremento);
        return valorActual;
    }

    public void reiniciarValor() {
        valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarValor();
    }

    public abstract T sumar(T o1, T o2);
}
