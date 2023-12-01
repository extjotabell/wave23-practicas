package meli.bootcamp.ej10;

import meli.bootcamp.ej10.prototipo.Serie2;
import meli.bootcamp.ej10.prototipo.Serie3;

/**
 * Ejercicio 10: Clases Abstractas
 */
public class Ej10Java {
  public static void main(String[] args) {
    Serie2 serie2 = new Serie2();
    serie2.iniciar(1);
    System.out.println(serie2.siguiente());
    System.out.println(serie2.siguiente());
    System.out.println(serie2.siguiente());
    System.out.println(serie2.siguiente());
    System.out.println(serie2.siguiente());
    serie2.reiniciar();
    Serie3 serie3 = new Serie3();
    serie3.iniciar(1.51);
    System.out.println(serie3.siguiente());
    System.out.println(serie3.siguiente());
    System.out.println(serie3.siguiente());
    System.out.println(serie3.siguiente());
    System.out.println(serie3.siguiente());
    serie3.reiniciar();
  }
}