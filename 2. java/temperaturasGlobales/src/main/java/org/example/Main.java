package org.example;

/*
Un portal de noticias tiene registrados datos de las diferentes temperaturas que
obtuvieron algunas ciudades del mundo durante el año pasado; a partir de estos registros,
pudieron determinar la más baja y la más alta para cada una de las ciudades. Por ejemplo,
se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C. Sin embargo,
actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura máxima
que hubo entre todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un
vector con los nombres de cada una de las ciudades y una matriz de dos columnas que
especifican su temperatura máxima y mínima, los cuales se especifican a continuación:
    -
    -
    -

Sabiendo que cada índice de fila representa a una ciudad. Se necesita conocer la mayor y
la menor temperatura entre todas las ciudades; al mismo tiempo se deberá especificar el
nombre de la ciudad. Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.

 */

public class Main {
            public static void main(String[] args) {
                String[] ciudades = {
                        "Londres",
                        "Madrid",
                        "Nueva York",
                        "Buenos Aires",
                        "Asunción",
                        "São Paulo",
                        "Lima",
                        "Santiago de Chile",
                        "Lisboa",
                        "Tokio"
                };

                int[][] temperaturas = {
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


                float minTemp = temperaturas[0][0];
                float maxTemp = temperaturas[0][1];
                String ciudadMaxTemp = ciudades[0];
                String ciudadMinTemp = ciudades[0];

                for (int i = 1; i < ciudades.length; i++) {
                    //Temperatura mas baja
                    if (temperaturas[i][0] <= minTemp) {
                        minTemp = temperaturas[i][0];
                        ciudadMinTemp = ciudades[i];
                    }

                    //Temperatura mas alta
                    if (temperaturas[i][1] >= maxTemp) {
                        maxTemp = temperaturas[i][1];
                        ciudadMaxTemp = ciudades[i];
                    }
                }
                System.out.printf("La ciudad %s posee la temperatura mas BAJA con %.2f\n", ciudadMinTemp, minTemp);
                System.out.printf("La ciudad %s posee la temperatura mas ALTA con %.2f\n", ciudadMaxTemp, maxTemp);

            }
        }


