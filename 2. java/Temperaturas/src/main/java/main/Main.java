package main;

public class Main {
    public static void main(String[] args) {

        String vectorCiudades[] = {
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

        int matrizTemperatura[][] = {
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

        int min = matrizTemperatura[0][0], max = matrizTemperatura[0][1], indMin = 0, indMax = 0;

        for (int i = 1; i < matrizTemperatura.length; i++) {

            if (matrizTemperatura[i][0] < min) {
                indMin = i;
                min = matrizTemperatura[i][0];
            }

            if (matrizTemperatura[i][1] > max) {
                indMax = i;
                max = matrizTemperatura[i][1];
            }

        }

        System.out.println("La temperatura más baja fue en la ciudad " + vectorCiudades[indMin] +
                ", con una temperatura de " + min);
        System.out.println("La temperatura más alta fue en la ciudad " + vectorCiudades[indMax] +
                ", con una temperatura de " + max);

    }
}