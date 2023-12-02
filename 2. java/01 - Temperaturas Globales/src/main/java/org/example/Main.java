package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "San Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int [][] temperaturas = {{-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42},
                {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

        int menorTemperatura = temperaturas [0][0];
        int mayorTemperatura = temperaturas [0][0];

        int indiceCiudadMayorTemperatura = 0;
        int indiceCiudadMenorTemperatura = 0;

        for (int f=0; f<temperaturas.length; f++){
            for (int c=0; c<temperaturas[f].length; c++){

                if(temperaturas[f][c]>mayorTemperatura){
                    mayorTemperatura = temperaturas[f][c];
                    indiceCiudadMayorTemperatura = f;
                }

                if(temperaturas[f][c]<menorTemperatura){
                    menorTemperatura = temperaturas[f][c];
                    indiceCiudadMenorTemperatura = f;
                }
            }
        }

        System.out.println("La ciudad con mayor temperatura es " + ciudades[indiceCiudadMayorTemperatura] +
                " con " + mayorTemperatura + "º.");
        System.out.println("La ciudad con menor temperatura es " + ciudades[indiceCiudadMenorTemperatura] +
                " con " + menorTemperatura + "º.");

    }
}
