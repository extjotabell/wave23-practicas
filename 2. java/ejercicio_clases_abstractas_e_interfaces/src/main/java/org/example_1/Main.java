package org.example_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <String> lista = new ArrayList<>();
        lista.add("Lector");
        lista.add("Programador");
        Persona persona = new Persona("Martin",26,lista);

        Curriculums cv = new Curriculums(persona);
        Pdf pdf = new Pdf(persona);

        System.out.println(pdf.imprimiendo());
    }
}
