package org.mercadolibre.model;

public class SeriesOfTwo extends ProgressiveSeries<Integer>{
    public SeriesOfTwo() {
        super(2);
    }

    @Override
    public Integer nextValue() {
        int result = currentValue;
        currentValue += 2;
        return result;
    }
}
