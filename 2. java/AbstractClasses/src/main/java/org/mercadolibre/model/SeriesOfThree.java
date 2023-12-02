package org.mercadolibre.model;

public class SeriesOfThree extends ProgressiveSeries<Integer>{
    public SeriesOfThree() {
        super(3);
    }

    @Override
    public Integer nextValue() {
        int result = currentValue;
        currentValue += 3;
        return result;
    }
}
