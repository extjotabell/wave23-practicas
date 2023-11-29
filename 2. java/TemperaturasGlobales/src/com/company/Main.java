package com.company;

public class Main {

    public static void main(String[] args) {

        String [] ciudades = {"Londrea","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minValue = 0;
        int maxValue = 0;
        String minCity = "";
        String maxCity = "";
        for(int i =0; i < ciudades.length; i++ ){
            if(temperatures[i][0] <= minValue){
                minValue = temperatures[i][0];
                minCity = ciudades[i];
            }
            if(temperatures[i][1] >= maxValue){
                maxValue=temperatures[i][1];
                maxCity = ciudades[i];
            }
        }
        System.out.println("La menor temperatura la tuvo "+ minCity + " con " + minValue + "º.");
        System.out.println("La mayor temperatura la tuvo "+ maxCity + " con " + maxValue + "º.");
    }
}
