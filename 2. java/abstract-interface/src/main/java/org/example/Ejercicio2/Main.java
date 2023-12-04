package org.example.Ejercicio2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ImprimibleImpl imprimible = new ImprimibleImpl();
        Persona persona = new Persona(
                "Florencia",
                "Leiva",
                27,
                List.of(
                        "Comunicación",
                        "Trabajo en equipo"
                ));

        Curriculum curriculums = new Curriculum(List.of(persona));
        Informes informes = new Informes();
        LibrosPDF librosPDF = new LibrosPDF();

        imprimible.imprimir(librosPDF);
        imprimible.imprimir(curriculums);
        imprimible.imprimir(informes);
    }
}