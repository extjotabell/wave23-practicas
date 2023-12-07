package org.example;

public class Serie extends Prototipo<Integer> {
    public Serie(int contador) {
        super(contador);
    }

    @Override
    public Integer generarActual(Integer a, Integer b) {
        return a + b;
    }
}

