package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Inscripcion> inscripcionesChico = new ArrayList<>();
        List<Inscripcion> inscripcionesMedio = new ArrayList<>();
        List<Inscripcion> inscripcionesAvanzado = new ArrayList<>();

        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria medio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria avanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1, "12345678", "Nombre1", "Apellido1", "093462324", "A-", 21);
        Participante participante2 = new Participante(2, "12345678", "Nombre2", "Apellido2", "093462324", "A-", 17);
        Participante participante3 = new Participante(3, "12345678", "Nombre3", "Apellido3", "093462324", "A-", 27);
        Participante participante4 = new Participante(4, "12345678", "Nombre4", "Apellido4", "093462324", "A-", 21);

        Inscripcion inscripcion1 = new Inscripcion(1, participante1, chico);
        Inscripcion inscripcion2 = new Inscripcion(2, participante2, medio);
        Inscripcion inscripcion3 = new Inscripcion(3, participante3, avanzado);
        Inscripcion inscripcion4 = new Inscripcion(4, participante4, avanzado);

        inscripcionesChico.add(inscripcion1);
        inscripcionesMedio.add(inscripcion2);
        inscripcionesAvanzado.add(inscripcion3);
        inscripcionesAvanzado.add(inscripcion4);

        System.out.println("Inscipciones categoria chico: ");
        for (Inscripcion i : inscripcionesChico) {
            i.MostrarDatos();
        }

        System.out.println("\n\nInscipciones categoria medio: ");
        for (Inscripcion i : inscripcionesMedio) {
            i.MostrarDatos();
        }

        System.out.println("\n\nInscipciones categoria avanzado: ");
        for (Inscripcion i : inscripcionesAvanzado) {
            i.MostrarDatos();
        }

        System.out.println("\n\nDesinscribiendo a categoria avanzado: ");
        inscripcionesAvanzado.remove(0);
        for (Inscripcion i : inscripcionesAvanzado) {
            i.MostrarDatos();
        }
    }
}