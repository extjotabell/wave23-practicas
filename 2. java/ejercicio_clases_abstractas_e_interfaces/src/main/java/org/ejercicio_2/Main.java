package org.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <String> lista = new ArrayList<>();
        lista.add("Lector");
        lista.add("Programador");
        Persona persona = new Persona("Martin",26,lista);

        Curriculums cv = new Curriculums(persona);

        List <String> habilidadesOscar = List.of("Escritor", "Poeta");
        Autor oscarWilde = new Autor("Oscar Wilde", 46, habilidadesOscar);

        Pdf libroRDG = new Pdf(300, "El Retrato de Dorian Gray", "Ficción gótica y filosófica", oscarWilde);

        List <String> habilidadesKevin = List.of("Corredor", "Científico");
        Revisor revisor = new Revisor("Dr. Kevin Steward", 158, habilidadesKevin);

        List <String> habilidadesFalcon = List.of("Corredor", "Cazarrecompensas");
        Autor autor = new Autor("Capitan Falcon", 1023, habilidadesFalcon);

        Informe informe = new Informe("¿Cómo ganar en F-zero 99?", 1234, autor, revisor);

        Imprimible.imprimirDocumentos(List.of(cv, libroRDG, informe));


    }
}
