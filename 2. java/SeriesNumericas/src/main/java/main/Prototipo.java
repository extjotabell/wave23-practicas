package main;

public abstract class Prototipo <T> {
    protected T valorInicial;
    protected T valorActual;
    protected T incremento;

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
        this.incremento = valorInicial;
    }

    public T getProxNumeroSerie() {
        return sumar(this.valorInicial, this.incremento);
    }
    public abstract T sumar(T a1, T a2);

    public void reiniciarSerie() {
        this.valorInicial = this.incremento;
        this.valorActual = this.incremento;
    };
    public void setValorInicialSerie(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }
}
