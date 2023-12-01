package main;

public class SerieInteger extends Prototipo<Integer> {
    public SerieInteger(Integer valorInicial) {
        super(valorInicial);
    }

    @Override
    public Integer sumar(Integer a1, Integer a2) {
        this.valorInicial += this.incremento;
        this.valorActual = this.valorInicial;
        return a1 + a2;
    }
}
