package org.example;

public class Main {
    public static void main(String[] args) {

        //se crea una serie de 2 con metodo valor siguiente
        System.out.println("---SERIE CADA 2---");
        Prototipo<Integer> serie = new Serie(2);
        serie.establecerValorInicial(2);

        for (int i = 0; i < 4; i++) {
            System.out.println("Serie: " + serie.valorSiguiente());
        }

        //establecer un valor inicial 1
        System.out.println("---ESTABLECER VALOR INICIAL 1---");
        serie.valorReiniciar();
        serie.establecerValorInicial(3);
        for (int i = 0; i < 4; i++) {
            System.out.println("Serie: " + serie.valorSiguiente());
        }

        //se crea una serie de 3 con metodo valor siguiente
        System.out.println("---SERIE CADA 3---");
        Prototipo<Integer> serieTres = new Serie(3);
        serieTres.establecerValorInicial(3);
        for (int i = 0; i < 4; i++) {
            System.out.println("Serie: " + serieTres.valorSiguiente());
        }
    }
}