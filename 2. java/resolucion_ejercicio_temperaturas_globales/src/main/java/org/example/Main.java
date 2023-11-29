package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {-7, 26}, {6, 42}, {5, 43}, {0, 39}, {-1, 31}, {-10, 35}};

        int temperaturaMaxima = Integer.MIN_VALUE;
        int temperaturaMinima = Integer.MAX_VALUE;
        String ciudadMaxima = "";
        String ciudadMinima = "";


        for (int i = 0; i < temperaturas.length; i++) {
            int temperaturaMaximaActual = temperaturas[i][1];
            int temperaturaMinimaActual = temperaturas[i][0];

            if (temperaturaMaximaActual > temperaturaMaxima) {
                temperaturaMaxima = temperaturaMaximaActual;
                ciudadMaxima = ciudades[i];
            }
            if (temperaturaMinimaActual < temperaturaMinima) {
                temperaturaMinima = temperaturaMinimaActual;
                ciudadMinima = ciudades[i];
            }
        }
        System.out.println("La temperatura máxima fue de " + temperaturaMaxima + " grados Celsius en " + ciudadMaxima);
        System.out.println("La temperatura mínima fue de " + temperaturaMinima + " grados Celsius en " + ciudadMinima);


    }
}