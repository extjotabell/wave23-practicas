package org.example.SeriesNumericas;

public abstract class Prototipo<T extends Object> {
    public abstract T nextValue();
    public abstract T restart();
    public abstract void setInitial(T initial);
}
