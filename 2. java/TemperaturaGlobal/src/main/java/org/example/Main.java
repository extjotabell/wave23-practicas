package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago", "Lisboa","Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43},{0,39}, {-7,26}, {-1,31}, {-10,35}};

        int max =temperaturas[0][1];
        int menor = temperaturas[0][0];
        int maxCiudad = 0;
        int menorCiudad = 0;
        int j = 0;

        for(int i = 0; i< ciudades.length; i++){
            if (temperaturas[i][j] < menor ){
                menor = temperaturas[i][j];
                menorCiudad = i;
            }
            j++;
            if (temperaturas[i][j]> max ){
                max = temperaturas[i][j];
                maxCiudad = i;
            }
            j = 0;
        }
        System.out.println(menor +" " + ciudades[menorCiudad]);
        System.out.println(max +" " + ciudades[maxCiudad]);
    }
}