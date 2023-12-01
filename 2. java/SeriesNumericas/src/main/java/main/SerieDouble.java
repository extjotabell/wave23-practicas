package main;

public class SerieDouble extends Prototipo<Double> {
    public SerieDouble(Double valorInicial) {
        super(valorInicial);
    }

    @Override
    public Double sumar(Double a1, Double a2) {
        this.valorInicial += this.incremento;
        this.valorActual = this.valorInicial;
        return a1 + a2;
    }
}
