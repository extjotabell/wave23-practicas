package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SerieBigDecimal serieBigDecimal = new SerieBigDecimal(BigDecimal.valueOf(2), BigDecimal.valueOf(5));

        serieBigDecimal.siguienteValor();
        serieBigDecimal.siguienteValor();
        serieBigDecimal.siguienteValor();

        System.out.println(serieBigDecimal.getValorActual());

        serieBigDecimal.reiniciarValor();

        System.out.println(serieBigDecimal.getValorActual());

    }
}