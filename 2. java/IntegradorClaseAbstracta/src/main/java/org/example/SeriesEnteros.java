package org.example;

public class SeriesEnteros extends Prototipo<Integer> {
    public SeriesEnteros(int paso) {
        super(paso);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
