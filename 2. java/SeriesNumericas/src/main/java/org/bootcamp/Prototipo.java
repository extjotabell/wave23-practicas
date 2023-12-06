package org.bootcamp;

public abstract class Prototipo <T>{

    protected T valor, serie;

    public Prototipo(T valor, T serie) {
        this.valor = valor;
        this.serie = serie;
    }

    public T getValor() {
        return valor;
    }

    public T getSerie() {
        return serie;
    }

    public void setSerie(T serie) {
        this.serie = serie;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public abstract void devuelveValor();

    public abstract void reinicioSerie();

    public abstract void estableceInicial(T valor);

}
