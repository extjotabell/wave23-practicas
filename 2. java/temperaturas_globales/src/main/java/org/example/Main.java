package org.example;

public class Main {
    public static void main(String[] args){
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int max = temperaturas[0][1];
        String ciudadConMax = ciudades[0];

        int min = temperaturas[0][0];
        String ciudadConMin = ciudades[0];

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > max) {
                max = temperaturas[i][1];
                ciudadConMax = ciudades[i];
            }
            if (temperaturas[i][0] < min) {
                min = temperaturas[i][0];
                ciudadConMin = ciudades[i];
            }
        }

        System.out.println("La mayor temperatura fue de " + max + "° en " + ciudadConMax);
        System.out.println("La menor temperatura fue de " + min + "° en " + ciudadConMin);
    }
}