package meli.bootcamp.ej2;

import meli.bootcamp.ej2.categoria.Categoria;
import meli.bootcamp.ej2.inscripcion.Inscripcion;
import meli.bootcamp.ej2.participante.Participante;

/**
 * Ejercicio 2: Carrera de la Selva
 */
public class Ej2Java {
  public static void main(String[] args) {
    Categoria chico = new Categoria("Circuito Chico", "2km por selva y arroyos", 1500.0, 1300.0, true);
    Categoria medio = new Categoria("Circuito Medio", "5km por selva, arroyos y barro", 2300.0, 2000.0, true);
    Categoria avanzado = new Categoria("Circuito Avanzado", "2km por selva y arroyos", 2800.0, null, false);

    Participante menor1 = new Participante("11222333", "Julian1", "Alvarez", 11, "1122223333", "1144445555", "A+");
    Participante menor2 = new Participante("11222333", "Julian2", "Alvarez", 9, "1122223333", "1144445555", "A+");
    Participante menor3 = new Participante("11222333", "Julian3", "Alvarez", 17, "1122223333", "1144445555", "A+");
    Participante mayor1 = new Participante("11222333", "Julian4", "Alvarez", 21, "1122223333", "1144445555", "A+");
    Participante mayor2 = new Participante("11222333", "Julian5", "Alvarez", 29, "1122223333", "1144445555", "A+");
    Participante mayor3 = new Participante("11222333", "Julian6", "Alvarez", 37, "1122223333", "1144445555", "A+");

    chico.inscribir(menor1);
    chico.inscribir(mayor1);
    medio.inscribir(menor2);
    medio.inscribir(mayor2);
    avanzado.inscribir(menor3);
    avanzado.inscribir(mayor3);

    for (Inscripcion inscripcion : chico.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }
    for (Inscripcion inscripcion : medio.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }
    for (Inscripcion inscripcion : avanzado.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }

    System.out.println("Se desinscribe una persona: ");
    mayor1.desinscribir();

    for (Inscripcion inscripcion : chico.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }
    for (Inscripcion inscripcion : medio.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }
    for (Inscripcion inscripcion : avanzado.getInscripciones()) {
      System.out.println(inscripcion.toString());
    }

    Double recaudadoChico = chico.totalRecaudado();
    Double recaudadoMedio = medio.totalRecaudado();
    Double recaudadoAvanzado = avanzado.totalRecaudado();

    System.out.println("Recaudado en chico: " + recaudadoChico);
    System.out.println("Recaudado en medio: " + recaudadoMedio);
    System.out.println("Recaudado en avanzado: " + recaudadoAvanzado);

    Double totalCategorias = recaudadoAvanzado + recaudadoChico + recaudadoMedio;
    System.out.println("Total recaudado en todas las categorias: " + totalCategorias);
  }
}
