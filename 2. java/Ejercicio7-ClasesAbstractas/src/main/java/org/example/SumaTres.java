package org.example;

import java.util.Objects;

public class SumaTres extends Prototipo{


    @Override
    public void siguienteNumero() {
        System.out.println(super.getValor());
        super.setValor(super.getValor() + 3);
    }
}
