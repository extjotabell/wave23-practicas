package org.example;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieEnteros = new SeriesEnteros(2);
        serieEnteros.establecerValorInicial(0);

        for (int i = 0; i < 5; i++) {
            System.out.println("Entero: " + serieEnteros.obtenerValorSiguiente());
        }

        System.out.println("Reiniciando serie...");
        serieEnteros.reiniciarSerie();
        serieEnteros.establecerValorInicial(1);
        for (int i = 0; i < 5; i++) {
            System.out.println("Entero: " + serieEnteros.obtenerValorSiguiente());
        }

        System.out.println("Reiniciando serie...");
        Prototipo<Integer> serieEnteros2 = new SeriesEnteros(3);
        serieEnteros2.establecerValorInicial(0);
        for (int i = 0; i < 5; i++) {
            System.out.println("Entero: " + serieEnteros2.obtenerValorSiguiente());
        }

        System.out.println("Serie con Doubles...");
        Prototipo<Double> serieDobles = new SeriesDoubles(1.5);
        serieDobles.establecerValorInicial(1.0);

        for (int i = 0; i < 5; i++) {
            System.out.println("Doble: " + serieDobles.obtenerValorSiguiente());
        }
    }
}
