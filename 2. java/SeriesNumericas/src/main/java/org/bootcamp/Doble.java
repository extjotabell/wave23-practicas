package org.bootcamp;

public class Doble extends Prototipo<Double>{

    private static final Double ZERO = 0D;

    public Doble(Double valor, Double serie) {
        super(valor, serie);
    }

    @Override
    public void devuelveValor() {
        setValor(this.getValor() + this.serie);
        System.out.println("Valor actual: " + getValor());
    }

    @Override
    public void reinicioSerie() {
        setValor(ZERO);
        System.out.println("Serie reiniciada a " + ZERO);
    }

    @Override
    public void estableceInicial(Double valor) {
        setValor(valor);
        System.out.println("Valor inicial establecido");
    }
}
