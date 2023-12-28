package org.example;

import java.util.Arrays;

public class main1 {
    public static void main(String[] args) {
        int[] numeros = {5,2,3,4,7,6};
        burbuja(numeros);
        for(int numero: numeros){
            System.out.println(numero);
        }
    }

    public static int[] burbuja(int[] array){
        Arrays.sort(array);
        return array;
    }
}
