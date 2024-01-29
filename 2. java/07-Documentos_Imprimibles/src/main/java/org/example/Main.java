package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Curriculum personaA = new Curriculum("Juan Pérez", "25", "Masculino");
        Curriculum personaB = new Curriculum("María González", "30", "Femenino");
        Curriculum personaC = new Curriculum("Carlos Rodríguez", "28", "Masculino");


        Informes informeA = new Informes("Buen desempeño", 10, "Ana Pérez", "Informe de Finanzas", "Carlos Gómez");
        Informes informeB = new Informes("Necesita mejorar en algunos aspectos", 8, "Juan Rodríguez", "Informe de Ventas", "María López");
        Informes informeC = new Informes("Excelente trabajo", 12, "Sofía Martínez", "Informe de Marketing", "Pedro Ramírez");


        Libros libroA = new Libros(300, "Gabriel García Márquez", "Cien años de soledad", "Realismo mágico");
        Libros libroB = new Libros(450, "J.K. Rowling", "Harry Potter y la piedra filosofal", "Fantasía");
        Libros libroC = new Libros(200, "George Orwell", "1984", "Ciencia ficción");


        personaA.imprimirTipoDocumento();
        personaA.imprimir();
        personaB.imprimirTipoDocumento();
        personaB.imprimir();
        personaC.imprimirTipoDocumento();
        personaC.imprimir();
        informeA.imprimir();
        informeA.imprimirTipoDocumento();
    }
}