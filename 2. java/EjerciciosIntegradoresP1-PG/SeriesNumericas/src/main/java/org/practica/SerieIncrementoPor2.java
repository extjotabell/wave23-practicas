package org.practica;

public class SerieIncrementoPor2 <T extends Number> extends Prototipo{

    public SerieIncrementoPor2(T initialValue) {
        super(initialValue);
    }

    @Override
    public T getNextValue() {
        T value = (T) this.getValue();
        T nextValue;
        if (value instanceof Double) {
            nextValue = (T) Double.valueOf(value.doubleValue() * 2.0);
        } else if (value instanceof Float) {
            nextValue = (T) Float.valueOf(value.floatValue() * 2f);
        } else if (value instanceof Long) {
            nextValue = (T) Long.valueOf(value.longValue() * 2);
        } else {
            nextValue = (T) Integer.valueOf(value.intValue() * 2);
        }
        setValue(nextValue);
        return (T) nextValue;
    }
}
