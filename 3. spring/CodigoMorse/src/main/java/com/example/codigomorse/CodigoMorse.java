package com.example.codigomorse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodigoMorse {
    private static final List<String> caracteresMorse = List.of(".-", "A", "-...", "B", "-.-.", "C", "-..", "D", ".","E", "..-.", "F", "--.", "G", "....", "H", "..", "I", ".---", "J", "-.-", "K", ".-..", "L", "--", "M", "-.", "N", "---", "O", ".--.", "P", "--.-", "Q", ".-.", "R", "...", "S", "-", "T", "..-", "U", "...-", "V", ".--", "W", "-..-", "X", "-.--", "Y", "--..", "Z", "-----", "0", ".----", "1", "..---", "2", "...--", "3", "....-", "4", ".....", "5", "-....", "6", "--...", "7", "---..", "8", "----.", "9", ".-.-.-", ".", "--..--", ",", "-.-.--", "!", "..--..", "?");

    public static String decodificarMorse(String mensaje){
        StringBuilder msgDecodificado = new StringBuilder();
        List<String> palabras = List.of(mensaje.split("   "));
        for (String palabra: palabras){
            List<String> caracteres = List.of(palabra.split(" "));
            for(String caracter: caracteres){
                msgDecodificado.append(caracterDecodificado(caracter));
            }
            msgDecodificado.append(" ");
        }
        return msgDecodificado.toString();
    }

    public static String codificarMorse(String mensaje){
        StringBuilder msgDecodificado = new StringBuilder();
        List<String> palabras = List.of(mensaje.split(" "));
        for (String palabra: palabras){
            int i=0;
            for(char caracter: palabra.toCharArray()){
                msgDecodificado.append(caracterCodificado(Character.toString(caracter)));
                i++;
                if(i!=palabra.length()){
                    msgDecodificado.append(" ");
                }
            }
            msgDecodificado.append("   ");
        }
        return msgDecodificado.toString();
    }

    public static String caracterDecodificado(String caracterMorse){
        return caracteresMorse.get(caracteresMorse.indexOf(caracterMorse) + 1);
    }
    public static String caracterCodificado(String caracter){
        return caracteresMorse.get(caracteresMorse.indexOf(caracter) -1);
    }
}
