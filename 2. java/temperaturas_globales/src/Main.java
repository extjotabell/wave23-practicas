package org.example;

public class Main {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        float[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        float low = temperatures[0][0];
        float high = temperatures[0][1];
        String cityHT = cities[0];
        String cityLT = cities[0];

        for(int i=1; i < cities.length;i++){
            //Temperatura mas baja
            if(temperatures[i][0] < low){
                low = temperatures[i][0];
                cityLT = cities[i];
            }

            //Temperatura mas alta
            if(temperatures[i][1] > high){
                high = temperatures[i][1];
                cityHT = cities[i];
            }
        }

        System.out.printf("La ciudad %s posee la temperatura mas BAJA con %.2f\n", cityLT, low);
        System.out.printf("La ciudad %s posee la temperatura mas ALTA con %.2f\n", cityHT, high);
    }
}