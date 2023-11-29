package org.ejercicios;

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


        float minTemp = temperaturas[0][0];
        float maxTemp = temperaturas[0][1];
        String ciudadMaxTemp = ciudades[0];
        String ciudadMinTemp = ciudades[0];
        
        for(int i=1; i < ciudades.length;i++){
            //Temperatura mas baja
            if(temperaturas[i][0] <= minTemp){
                minTemp = temperaturas[i][0];
                ciudadMinTemp = ciudades[i];
            }

            //Temperatura mas alta
            if(temperaturas[i][1] >= maxTemp){
                maxTemp = temperaturas[i][1];
                ciudadMaxTemp = ciudades[i];
            }
        }
        System.out.printf("La ciudad %s posee la temperatura mas BAJA con %.2f\n", ciudadMinTemp, minTemp);
        System.out.printf("La ciudad %s posee la temperatura mas ALTA con %.2f\n", ciudadMaxTemp, maxTemp);


    }
}