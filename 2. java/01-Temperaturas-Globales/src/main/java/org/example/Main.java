package org.example;
//MARCOS MARTINEZ JORGE RODRIGO
// IT BOOTCAMP 2023
// 29 de noviembre de 2023
/*
    Temperaturas Globales

    Un portal de noticias tiene registrados datos de las diferentes temperaturas
    que obtuvieron algunas ciudades del mundo durante el año pasado; a partir
    de estos registros, pudieron determinar la más baja y la más alta para cada una de las ciudades.
    Por ejemplo, se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C.
    Sin embargo, actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura máxima
    que hubo entre todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un vector con
    los nombres de cada una de las ciudades y una matriz de dos columnas que especifican su temperatura
    máxima y mínima, los cuales se especifican a continuación:

    Sabiendo que cada índice de fila representa a una ciudad.
    Se necesita conocer la mayor y la menor temperatura entre todas las ciudades;
    al mismo tiempo se deberá especificar el nombre de la ciudad.
    Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.

*/
public class Main {
    public static void main(String[] args) {
        String [] ciudades = {"Londres","Madrid","New York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago Chile","Lisboa","Tokio"};
        int [][] temperaturas = {
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
        int i,j=0;
        int temperaturaMaxima, mayorTemperatura = 0, temperaturaMinima, menorTemperatura=0;
        for(i=0;i<ciudades.length;i++){
            System.out.println("Ciudad: " + ciudades[i] + " con Temperatura Maxima de:" + temperaturas[i][0] + " y minima de: " + temperaturas[i][1]);
        }

        System.out.println("CALCULANDO TEMPERATURAS MAXIMAS Y MINIMAS ... ... ...");

        for (i=0;i<ciudades.length;i++){
            temperaturaMaxima = temperaturas[i][1];
            if(temperaturaMaxima>mayorTemperatura){
                mayorTemperatura = temperaturaMaxima;
                j=i;
            }
        }
        System.out.println("La temperatura Maxima fue de: " + mayorTemperatura + " en la ciudad de: " + ciudades[j]);
        j=0;
        for (i=0;i<ciudades.length;i++){
            temperaturaMinima = temperaturas[i][0];
            if(temperaturaMinima<menorTemperatura){
                menorTemperatura = temperaturaMinima;
                j=i;
            }
        }
        System.out.println("La temperatura Minima fue de: " + menorTemperatura + " en la ciudad de: " + ciudades[j]);


    }
}