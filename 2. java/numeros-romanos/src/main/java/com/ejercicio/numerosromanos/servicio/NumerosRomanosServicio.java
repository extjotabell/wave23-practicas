package com.ejercicio.numerosromanos.servicio;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosServicio {

    private int [] numeros = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private String [] equivalencias = {"I", "IV" ,"V", "IX", "X", "XL", "L", "XC", "C", "CD", "D","CM", "M"};
    public String convertirANumeroRomano(int numero){
        int index = numeros.length-1;
        String resultado = "";

        while (numero > 0){
            while (numero >= numeros[index]) {
                resultado += equivalencias[index];
                numero = numero - numeros[index];
            }
            index--;
        }
        return  resultado;
    }
}
