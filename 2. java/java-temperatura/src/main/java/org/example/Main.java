package org.example;

public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minValue = temperatures[0][0];
        int minIndex = 0;
        int maxValue = temperatures[0][1];
        int maxIndex = 0;

        for (int x = 1; x < cities.length; x++) {
            int minTemp = temperatures[x][0];
            int maxTemp = temperatures[x][1];

            if (minTemp < minValue) {
                minValue = minTemp;
                minIndex = x;
            }

            if (maxTemp > maxValue) {
                maxValue = maxTemp;
                maxIndex = x;
            }
        }
        System.out.println("La menor temperatura fue: " + minValue + "° en " + cities[minIndex]);
        System.out.println("La mayor temperatura fue: " + maxValue + "° en " + cities[maxIndex]);
    }
}