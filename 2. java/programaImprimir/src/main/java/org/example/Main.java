package org.example;

import org.example.clases.Curriculum;
import org.example.clases.Imprimible;
import org.example.clases.Informe;
import org.example.clases.LibroPDF;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Celeste", 20, Arrays.asList("hablilidad1","hablilidad2"));
        LibroPDF libroPDF = new LibroPDF(100,"Stephen King", "El Resplandor", "Terror");
        Informe informe = new Informe("Texto informe..", 271, "Claudia Vargas", "Meli");

        imprimirDocumento(curriculum);
        imprimirDocumento(libroPDF);
        imprimirDocumento(informe);
    }
    public static void imprimirDocumento(Imprimible imprimible) {
        imprimible.imprimirDoc();
    }
}