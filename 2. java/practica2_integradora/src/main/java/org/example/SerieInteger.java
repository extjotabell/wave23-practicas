package org.example;

public class SerieInteger extends SerieProgresiva<Integer> {
    public SerieInteger(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer sumar(Integer o1, Integer o2) {
        return o1 + o2;
    }
}
