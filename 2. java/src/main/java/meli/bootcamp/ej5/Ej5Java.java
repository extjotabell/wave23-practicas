package meli.bootcamp.ej5;

import meli.bootcamp.ej5.distribuidora.Distribuidora;

/**
 * Ejercicio 5: Introduccion al lenguaje Java - Practica Integradora POO 2 - Ej
 * 2/2
 */
public class Ej5Java {
  public static void main(String[] args) {
    Distribuidora supermercado = new Distribuidora();
    System.out.println("Total del supermercado: " + supermercado.calcularTotalProductos());
  }
}
