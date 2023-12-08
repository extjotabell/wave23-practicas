package org.java;

import java.math.BigInteger;

public class SerieDeTres extends Prototipo {
    public SerieDeTres() {
        super(new BigInteger("3"));
    }

    @Override
    BigInteger getNextValor() {
        valor = valor.add(increment);
        return valor;
    }
}
