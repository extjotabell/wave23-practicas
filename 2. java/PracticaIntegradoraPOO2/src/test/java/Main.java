public class Main {
    public static void main(String[] args) {
        practicaExcepciones();
    }
    public static void practicaExcepciones() {
        PracticaExcepciones practica = new PracticaExcepciones();

        try {
            double resultado = practica.calcularCociente();

        } catch (ArithmeticException out) {
            throw  new IllegalArgumentException("No se puede dividir por cero.");

        }finally {
            System.out.println("Programa finalizado.");
        }
    }
}
