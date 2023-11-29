package org.example;
public class Main {
    public static void main(String[] args) {
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

        int minTemp = temperaturas[0][0];
        int maxTemp = temperaturas[0][1];
        String ciudadMaxTemp = "";
        String ciudadMinTemp = "";
        System.out.println(ciudades.length);
        for (int i = 0; i < ciudades.length; i++) {
            if (minTemp > temperaturas[i][0]) {
                minTemp = temperaturas[i][0];
                ciudadMinTemp = ciudades[i];
            }
            if (maxTemp < temperaturas[i][1]) {
                maxTemp = temperaturas[i][1];
                ciudadMaxTemp = ciudades[i];
            }
        }

        System.out.println("La ciudad con menor temperatura es: " + ciudadMinTemp + " con " + minTemp + "°C");
        System.out.println("La ciudad con mayor temperatura es: " + ciudadMaxTemp + " con " + maxTemp + "°C");
    }
}