package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int indiceMin = 0, indiceMax = 0;

        for (int i = 0; i < cities.length; i++){
                if (temperatures[i][0] < min){
                    min = temperatures[i][0];
                    indiceMin = i;
                }

                if (temperatures[i][1] > max){
                    max = temperatures[i][1];
                    indiceMax = i;
                }
        }

        System.out.println("La menor temperatura la tuvo " + cities[indiceMin] + " con " + min + "ºC");
        System.out.println("La mayor temperatura la tuvo " + cities[indiceMax] + " con " + max + "ºC");
    }
}