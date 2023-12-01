package meli.bootcamp.ej7;

import meli.bootcamp.ej7.imprimible.CurriculumImpl;
import meli.bootcamp.ej7.imprimible.IImprimible;
import meli.bootcamp.ej7.imprimible.InformeImpl;
import meli.bootcamp.ej7.imprimible.LibroPdfImpl;
import meli.bootcamp.ej7.persona.Persona;

/**
 * Ejercicio 7: Clases Abstractas e Interfaces - Practica Integradora - Ej 2/3
 */
public class Ej7Java {
  public static void main(String[] args) {
    Persona yo = new Persona("Tiago Ramirez", "Software Developer");
    yo.agregarHabilidad("Java");
    yo.agregarHabilidad("Docker");
    yo.agregarHabilidad("Git");
    CurriculumImpl curriculum = new CurriculumImpl(yo);
    LibroPdfImpl libro = new LibroPdfImpl(23, "Jorge", "Algo", "Terror");
    InformeImpl informe = new InformeImpl("algo loco", 32, "Some1", "Anonimus");

    imprimir(curriculum);
    imprimir(libro);
    imprimir(informe);
  }

  public static void imprimir(IImprimible imprimible) {
    imprimible.imprimir();
  }
}
