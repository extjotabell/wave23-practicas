package org.bootcamp;

public class Entero extends Prototipo<Integer>{

    private static final Integer ZERO = 0;

    public Entero(Integer valor, Integer serie) {
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
    public void estableceInicial(Integer valor) {
        setValor(valor);
        System.out.println("Valor inicial establecido");
    }
}
