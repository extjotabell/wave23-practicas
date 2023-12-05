package org.example;


public class Main {
    public static void main(String[] args) {
        SerieInteger serieInteger = new SerieInteger(3);
        SerieDouble serieDouble = new SerieDouble(2.2);

        System.out.println("---------- Integer ----------");

        //serieInteger.establecerValorInicial(1);

        for(int i = 0; i < 4; i++){
            serieInteger.valor = serieInteger.generarSiguiente();
            System.out.println(serieInteger.valor);
        }

        System.out.println("---------- Double ----------");

        serieDouble.establecerValorInicial(1.1);

        for(int j = 0; j < 4; j++){
            serieDouble.valor = serieDouble.generarSiguiente();
            System.out.println(serieDouble.valor);
        }
    }
}