package meli.bootcamp.ej3;

import meli.bootcamp.ej3.persona.Persona;

/**
 * Ejercicio 3: Introduccion al lenguaje Java - Practica Integradora POO
 */
public class Ej3Java {
  public static void main(String[] args) {
    Persona tiago = new Persona("Tiago Ramirez", 22, "11222333", 70.0, 1.82);
    // Persona random = new Persona("Random Random",22); <- ROMPE
    System.out.println("IMC: " + tiago.calcularIMC());
    if (tiago.esMayorDeEdad()) {
      System.out.println("Es mayor de edad");
    } else {
      System.out.println("Es menor de edad");
    }
    System.out.println(tiago.toString());
  }
}
