package org.example;

public class Main {
    public static void main(String[] args) {

        String [] ciudad = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};

        int [][] grados = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int min = 0, max = 0;

        String ciudadMin = "" ,ciudadMax = "";

        for (int i = 0; i < ciudad.length; i++) {


                if(grados[i][0] < min) {
                    min = grados[i][0];
                    ciudadMin = ciudad[i];
                }

                if(grados[i][1] > max) {
                    max = grados[i][1];
                    ciudadMax = ciudad[i];
                }


        }

        System.out.println("La ciudad con menor grado es " + ciudadMin + " con " + min);
        System.out.println("La ciudad con mayor grado es " + ciudadMax + " con " + max);













    }
}