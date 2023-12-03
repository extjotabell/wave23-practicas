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
        Pdf pdf = new Pdf(10,"El llegado","Accion",persona);
        Informes informe = new Informes(10,15,persona,"Critico");

        System.out.println(informe.imprimiendo());
    }
}
