package org.java;

import java.math.BigInteger;

public class SerieDeDos extends Prototipo {
    public SerieDeDos() {
        super(new BigInteger("2"));
    }

    @Override
    BigInteger getNextValor() {
        valor = valor.add(increment);
        return valor;
    }
}
