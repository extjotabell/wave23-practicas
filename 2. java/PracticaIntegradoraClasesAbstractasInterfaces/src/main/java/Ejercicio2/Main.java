package org.example;

import org.example.modelo.Curriculum;
import org.example.modelo.Imprimible;
import org.example.modelo.Informe;
import org.example.modelo.LibroPDF;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Sebas Ospina", 23, "Calle A, 123", Arrays.asList("Java", "Spring", "SQL"));
        LibroPDF libroPDF = new LibroPDF(300, "Autor del Libro", "Título del Libro", "Ficción");
        Informe informe = new Informe("Este es un informe muy importante.", 12, "Autor del Informe", "Revisor del Informe");

        imprimirDocumento(curriculum);
        imprimirDocumento(libroPDF);
        imprimirDocumento(informe);
    }

    public static void imprimirDocumento(Imprimible documento) {
        documento.imprimir();
    }
}