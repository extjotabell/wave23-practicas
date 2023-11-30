package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            PracticaExcepciones.calcular();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class PracticaExcepciones {
    private static final int a = 0, b = 300;

    public static void calcular() {
        try {
            int cociente = b / a;
            System.out.println("El resultado es: " + cociente);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
