package org.example;

import java.math.BigDecimal;

public class SerieBigDecimal extends SerieProgresiva<BigDecimal> {
    public SerieBigDecimal(BigDecimal valorInicial, BigDecimal incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public BigDecimal sumar(BigDecimal o1, BigDecimal o2) {
        return o1.add(o2);
    }
}
