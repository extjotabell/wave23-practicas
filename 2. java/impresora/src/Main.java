package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DocumentoImpl d1 = new Curriculum(new Persona("Marcos", "Costanzo", "40955907", List.of(new String[]{"habilidad1","habilidad2"})));
        DocumentoImpl d2 = new LibroEnPDF(25, "Pepe", "Programación en C", "Educativo");
        DocumentoImpl d3 = new Informe("Informe de prueba", 15, "Carlos", "Sofia");

        Impresora.imprimir(d1);
        System.out.println(" ----------------------- ");
        Impresora.imprimir(d2);
        System.out.println(" ----------------------- ");
        Impresora.imprimir(d3);
        System.out.println(" ----------------------- ");
    }

}
