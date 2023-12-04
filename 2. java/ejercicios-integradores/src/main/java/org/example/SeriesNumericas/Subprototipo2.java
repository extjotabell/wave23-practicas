package org.example.SeriesNumericas;

public class Subprototipo2 extends Prototipo {
    private Integer increment;
    private Integer value;

    public Subprototipo2(Integer increment, Integer value) {
        this.increment = increment;
        this.value = value;
    }

    @Override
    public Object nextValue() {
        return this.value += this.increment;
    }

    @Override
    public Object restart() {
        return this.value = 0;
    }

    @Override
    public void setInitial(Object initial) {
        this.value = (Integer) initial;
    }
}
