package com.example.demo;

public class Main {
    public static void main(String[] args ){

        // VECTOR CIUDADES
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        // MATRIZ TEMPERATURAS
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

        int temperaturaMax = temperaturas[0][1];
        int temperaturaMin = temperaturas[0][0];
        String ciudadMax = ciudades[0];
        String ciudadMin = ciudades[0];

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }

            if (temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
        }

        System.out.println("La mayor temperatura la tuvo "+ ciudadMax +" con "+ temperaturaMax + " ºC");
        System.out.println("La menor temperatura la tuvo " + ciudadMin + " con "+ temperaturaMin + " ºC");
    }
}