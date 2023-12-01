package Ejercicio1;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int dividir() {
        try {
            int resultado = b / a;
            return resultado;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
