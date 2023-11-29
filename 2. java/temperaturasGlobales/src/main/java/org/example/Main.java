package org.example;

public class Main {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int maxValue = temperatures[0][1];
        int minValue = temperatures[0][0];

        int indexMin = 0;
        int indexMax = 0;

        for (int i = 0; i < 10; i++) {
            int tempMin = temperatures[i][0];
            int temMax = temperatures[i][1];

            if(tempMin <= minValue){
                minValue = tempMin;
                indexMin++;
            }

            if(temMax <= maxValue){
                maxValue = temMax;
                indexMax++;
            }

            System.out.print("La mayor temperatura lo tuvo " + " " + cities[indexMax] + " y es de " + temMax + "º ");
            System.out.println("La menor temperatura lo tuvo " + " " + cities[indexMin] + " y es de " + tempMin + "º ");
        }

    }
}