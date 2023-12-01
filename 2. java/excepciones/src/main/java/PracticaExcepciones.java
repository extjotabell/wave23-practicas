public class PracticaExcepciones {
    private static final int a = 0;
    private static final int b = 300;

    public static void calcularCociente() {
        try {
            System.out.println(b/a);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir entre cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
