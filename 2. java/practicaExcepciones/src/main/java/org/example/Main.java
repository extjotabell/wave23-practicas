package org.example;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones ejercicioExcepciones = new PracticaExcepciones(0,30);
        //controlar excepcion con ArithmeticException
        ejercicioExcepciones.calculaCocienteFormaUno();
        //controlar excepcion con IllegalArgumentException
        ejercicioExcepciones.calculaCocienteFormaDos();

    }
}