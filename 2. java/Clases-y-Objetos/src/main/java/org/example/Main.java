package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Libro libro1 = new Libro("Harry Potter","J.K Rowling", 20);

        System.out.println(libro1.mostrarLibros( ));
        System.out.println(libro1.cantidadEjemplares() );
    }
}