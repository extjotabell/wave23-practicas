package org.example;

public class Main {

    public static int posicionCiudadTempMaxima;
    public  static int posicionCiudadTempMinima;

    public static void main(String[] args) {

        final int VAL_MAXIMO = 1;
        final int VAL_MINIMO = 0;

        String ciudades[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int vector[] = new int[5];

        int temperatura[][] = {
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
        int valMaximo = getValoresMinimoMaximoTemperaturas(temperatura)[VAL_MAXIMO];
        int valMinimo = getValoresMinimoMaximoTemperaturas(temperatura)[VAL_MINIMO];

        System.out.println("La mayor temperatura es " + valMaximo + " y la ciudad es " + ciudades[posicionCiudadTempMaxima]);
        System.out.println("La menor temperatura es " + valMinimo + " y la ciudad es " + ciudades[posicionCiudadTempMinima]);
    }

    public static int[] getValoresMinimoMaximoTemperaturas(int temperatura[][]){
        int valMinimo = temperatura[0][0];
        int valMaximo = temperatura[0][1];
        for (int i = 0; i<10; i++){
            for (int j = 0; j < 2; j++) {
                valMinimo = getValorMinimo(temperatura[i][j], valMinimo, i);
                valMaximo = getValorMaximo(temperatura[i][j], valMaximo, i);
            }
        }
        return new int[]{valMinimo, valMaximo};
    }
    public static int getValorMinimo(int temperatura, int valMinimo, int posicionCiudad){
        if(temperatura < valMinimo) {
            valMinimo = temperatura;
            posicionCiudadTempMinima = posicionCiudad;
        }
        return  valMinimo;
    }

    public static int getValorMaximo(int temperatura, int valMaximo, int posicionCiudad){
        if(temperatura > valMaximo) {
            valMaximo = temperatura;
            posicionCiudadTempMaxima = posicionCiudad;
        }
        return  valMaximo;
    }
}