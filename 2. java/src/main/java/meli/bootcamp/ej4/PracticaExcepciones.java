package meli.bootcamp.ej4;

public class PracticaExcepciones {
  private static int a = 0;
  private static int b = 300;

  public static void calcularCociente() {
    try {
      if (a == 0) {
        throw new IllegalArgumentException("No se puede dividir por cero");
      }
      int resultado = b / a;
      System.out.println(resultado);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (ArithmeticException e) {
      System.out.println("Se ha producido un error");
    }
    System.out.println("Programa finalizado");
  }
}
