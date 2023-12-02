package org.example;

public abstract class Prototype<T extends Number> {

    abstract T getNumberNextProgressive();

    abstract void restartSerie();

    abstract void setNumberNextProgresive(T number);

}
