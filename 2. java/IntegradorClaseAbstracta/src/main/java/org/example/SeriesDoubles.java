package org.example;

public class SeriesDoubles extends Prototipo<Double> {
    public SeriesDoubles(double paso) {
        super(paso);
    }

    @Override
    protected Double sumar(Double a, Double b) {
        return a + b;
    }
}
