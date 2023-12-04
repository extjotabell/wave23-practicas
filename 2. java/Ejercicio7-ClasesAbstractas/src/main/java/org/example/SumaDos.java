package org.example;

import java.util.Objects;

public class SumaDos extends Prototipo{


    @Override
    public void siguienteNumero() {
        System.out.println(super.getValor());
       super.setValor(super.getValor() + 2);

    }
}
