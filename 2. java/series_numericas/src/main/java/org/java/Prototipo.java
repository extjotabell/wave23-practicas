package org.java;

import java.math.BigInteger;

public abstract class Prototipo {
    protected BigInteger valor;
    protected BigInteger increment;

    public Prototipo(BigInteger increment) {
        this.increment = increment;
        this.valor = BigInteger.ZERO;
    }

    abstract BigInteger getNextValor();

    public void resetSeries() {
        this.valor = BigInteger.ZERO;
    }

    public void initializeValor(BigInteger initialValor) {
        this.valor = initialValor.subtract(increment);
    }
}
