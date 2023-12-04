package org.example.SeriesNumericas;

public class Subprototipo1 extends Prototipo {
    private Double increment;
    private Double value;

    public Subprototipo1(Double increment, Double value) {
        this.increment = increment;
        this.value = value;
    }

    @Override
    public Object nextValue() {
        return this.value += this.increment;
    }

    @Override
    public Object restart() {
        return this.value = 0.0;
    }

    @Override
    public void setInitial(Object initial) {
        this.value = (Double) initial;
    }
}
