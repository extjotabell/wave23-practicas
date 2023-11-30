public class PracticaExcepciones {

    private final int a = 0;
    private final int b = 300;

    // Ejercicio 1
    /*public double calcularCociente() {
        try {
            return this.b / this.a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            return -1;
        } finally {
            System.out.println("Programa finalizado");
        }
    }*/

    // Ejercicio 2
    public double calcularCociente() {
        try {
            return this.b / this.a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
