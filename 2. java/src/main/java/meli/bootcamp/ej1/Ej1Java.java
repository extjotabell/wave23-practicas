package meli.bootcamp.ej1;

/**
 * Ejercicio 1: Temperaturas globales
 */
public class Ej1Java {
  public static void main(String[] args) {
    String[] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima",
        "Santiado de Chile", "Lisboa", "Tokyo" };

    int[][] temperaturas = { { -2, 33 }, { -3, 32 }, { -8, 27 }, { 4, 37 }, { 6, 42 }, { 5, 43 }, { 0, 39 }, { -7, 26 },
        { -1, 31 }, { -10, 35 } };

    String ciudadTemperaturaMinima = "";
    int temperaturaMinima = 100;
    String ciudadTemperaturaMaxima = "";
    int temperaturaMaxima = -100;

    for (int i = 0; i < ciudades.length; i++) {
      for (int j = 0; j < 2; j++) {
        if (j == 0 && temperaturas[i][j] < temperaturaMinima) {
          temperaturaMinima = temperaturas[i][j];
          ciudadTemperaturaMinima = ciudades[i];
        } else if (j == 1 && temperaturas[i][j] > temperaturaMaxima) {
          temperaturaMaxima = temperaturas[i][j];
          ciudadTemperaturaMaxima = ciudades[i];
        }
      }
    }

    System.out.println("Ciudad con temperatura minima: " + ciudadTemperaturaMinima);
    System.out.println("Ciudad con temperatura maxima: " + ciudadTemperaturaMaxima);
  }
}
