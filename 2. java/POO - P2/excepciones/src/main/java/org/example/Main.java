package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        PracticaExcepciones practica = new PracticaExcepciones();
        Producto producto = new Producto("Arroz", 49.5);
        Perecedero productoPerecedero = new Perecedero("Lechuga", 25,2);
        NoPerecedero productoNoPerecedero = new NoPerecedero("Arroz", 49.5,"NoPerecedero");


        practica.calculoCociente1();
        System.out.println("X---------------------------------------X");
        practica.calculoCociente2();

        System.out.println("X---------------------------------------X");
        System.out.println("Resultado del calculo:" + producto.calcular(7));

        System.out.println("X---------------------------------------X");
        System.out.println("Resultado del calculo:" + productoPerecedero.calcular(6));

        System.out.println("X---------------------------------------X");
        System.out.println("Resultado del calculo:" + productoNoPerecedero.calcular(7));


        System.out.println("X---------------------------------------X");
        Distribuidora distribuidora = new Distribuidora();
        Producto[] productos={
                new Producto("Arroz", 49.5),
                new Perecedero("Lechuga", 25,2),
                new NoPerecedero("Arroz", 49.5,"NoPerecedero"),
                new Producto("Fideo", 49.8),
                new Producto("Lenteja", 46.5),

        };

        System.out.println("Resultado del calculo:" + distribuidora.calcularPrecioTotal(productos,5));
    }
}