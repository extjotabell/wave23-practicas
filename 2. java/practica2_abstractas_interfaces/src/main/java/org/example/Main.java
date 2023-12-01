package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Documento informe = new Informe("Texto", 10, "Autor", "Revisor");
        Documento curriculum = new Curriculum("Nombre", "Apellido", "Dni", 22, Arrays.asList("Java", "Python"));
        Documento libro = new Libro("Genero", 20, "Autor", "Titulo");

        informe.imprimir();
        curriculum.imprimir();
        libro.imprimir();

        Imprimible.imprimirDoc(informe);
    }
}
