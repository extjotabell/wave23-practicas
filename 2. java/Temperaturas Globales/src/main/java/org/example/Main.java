package org.example;

public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int maxValue = temperatures[0][1]; //Integer.MIN_VALUE
        int minValue = temperatures[0][0]; //Integer.MAX_VALUE

        int indexMin = 0;
        int indexMax = 0;

        for (int i = 1; i < cities.length; i++){

            int tempMin = temperatures [i][0];
            int tempMax = temperatures [i][1];

            if(tempMin < minValue){
                minValue = tempMin;
                indexMin = i;
            }

            if(tempMax > maxValue){
                maxValue = tempMax;
                indexMax = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + cities[indexMin] + " con " + minValue + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + cities[indexMax] + " con " + maxValue + " ºC.");
    }
}