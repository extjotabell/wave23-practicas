package org.example;
/*
Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”.
Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
* */

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones excepcion = new PracticaExcepciones(0,300);
        excepcion.calcularCociente();
    }
}