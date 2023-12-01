package org.mercadolibre;

import org.mercadolibre.model.PracticaExcepciones;

public class PracticaExcepcionesMain {

    public static void main(String[] args) {
        int a = 0;
        int b = 100;

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(a, b);
        practicaExcepciones.calcularCociente();

    }
}
