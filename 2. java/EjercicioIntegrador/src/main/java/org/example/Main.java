package org.example;

public class Main {
    public static void main(String[] args) {

        Prototipo<Integer> serie1 = new SerieEnteros(2);
        Prototipo<Double> serie2 = new SerieDouble(3.0);
        System.out.println("Iniciando serie");
        serie1.iniciarSerie(2);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(serie1.siguienteNumero());
        }
        System.out.println("Reiniciando serie");
        serie1.reiniciarSerie();
        for (int i = 0; i < 3 ; i++) {
            System.out.println(serie1.siguienteNumero());
        }
        System.out.println("Iniciando serie");
        serie2.iniciarSerie(3.0);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(serie2.siguienteNumero());
        }
        System.out.println("Reiniciando serie");
        serie2.reiniciarSerie();
        for (int i = 0; i < 3 ; i++) {
            System.out.println(serie2.siguienteNumero());
        }


    }
}