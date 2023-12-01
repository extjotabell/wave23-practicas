package main;

public class SerieFloat extends Prototipo<Float> {
    public SerieFloat(Float valorInicial) {
        super(valorInicial);
    }

    @Override
    public Float sumar(Float a1, Float a2) {
        this.valorInicial += this.incremento;
        this.valorActual = this.valorInicial;
        return a1 + a2;
    }
}
