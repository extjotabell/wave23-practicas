package org.example;

public class SerieDouble extends Prototipo<Double> {
    public SerieDouble(double contador) {
        super(contador);
    }

    @Override
    public Double generarActual(Double a, Double b) {
        return a + b;
    }
}
