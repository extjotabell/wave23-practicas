package org.mercadolibre.model;

/*
 * "Classes should be prepared to receive any non-primitive numeric data type."
 * That's why we use: <T extends Number>. It is a generic type declaration in Java.
 * The Number class is an abstract class in Java that serves as the superclass for wrapper classes
 * of primitive numeric types such as Integer, Double, Long, etc.
*/
public abstract class ProgressiveSeries <T extends Number>{
    protected T initialValue;
    protected T currentValue;

    public ProgressiveSeries(T initialValue) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
    }

    /*
    * The method nextValue() is declared abstract in the prototype class SerieProgresiva
    * because its concrete implementation will depend on subclasses. Each subclass extending
    * ProgressiveSeries must provide its own specific implementation for nextValue(),
    * adhering to the concept of polymorphism in Java.
    * */
    public abstract T nextValue();

    public void restartSeries() {
        this.currentValue = initialValue;
    }

    public void setInitialValue(T newInitialValue) {
        this.initialValue = newInitialValue;
        this.currentValue = newInitialValue;
    }

}
