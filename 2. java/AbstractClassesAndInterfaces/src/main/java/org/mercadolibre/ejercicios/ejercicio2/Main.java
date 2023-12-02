package org.mercadolibre.ejercicios.ejercicio2;

import org.mercadolibre.ejercicios.ejercicio2.model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>(Arrays.asList("Java", "Python", "SQL"));
        Person person = new Person("Juan", "11234563", skills);
        Curriculum curriculum = new Curriculum(1, person);

        IPrintable.printContent(curriculum);

        Reports reports = new Reports(1, "Texto", 50, "Luis Suarez", person);
        IPrintable.printContent(reports);

        PDFBooks pdfBooks = new PDFBooks(1, 100, "Luis Suarez", "Programacion orientada a objetos", "Tecnología");
        IPrintable.printContent(pdfBooks);
    }
}
