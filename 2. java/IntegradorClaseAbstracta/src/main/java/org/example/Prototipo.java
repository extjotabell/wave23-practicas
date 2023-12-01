package org.example;

public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T valorActual;
    protected T paso;

    public Prototipo(T paso) {
        this.paso = paso;
        reiniciarSerie();
    }

    public T obtenerValorSiguiente() {
        T valorSiguiente = valorActual;
        valorActual = sumar(valorActual, paso);
        return valorSiguiente;
    }

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }

    protected abstract T sumar(T a, T b);
}
