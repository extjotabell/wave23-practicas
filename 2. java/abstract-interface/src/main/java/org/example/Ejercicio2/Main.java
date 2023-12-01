package org.example;

public class Main {

    public static void main(String[] args) {

        ImprimibleImpl imprimible = new ImprimibleImpl();

        Curriculums curriculums = new Curriculums();
        Informes informes = new Informes();
        LibrosPDF librosPDF = new LibrosPDF();

        imprimible.imprimir(librosPDF);
        imprimible.imprimir(curriculums);
        imprimible.imprimir(informes);

    }
}