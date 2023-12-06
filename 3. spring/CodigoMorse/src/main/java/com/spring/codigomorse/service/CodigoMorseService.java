package com.spring.codigomorse.service;

import java.util.*;

public class CodigoMorseService {
    //String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> morseMap = new HashMap<>();
    Map<String, String> letraMap = new HashMap<>();

    public void IniciarMorseMaps() {
        if (morseMap.isEmpty()) {
            morseMap.put(".-", "A");
            morseMap.put("-...", "B");
            morseMap.put("-.-.", "C");
            morseMap.put("-..", "D");
            morseMap.put(".", "E");
            morseMap.put("..-.", "F");
            morseMap.put("--.", "G");
            morseMap.put("....", "H");
            morseMap.put("..", "I");
            morseMap.put(".---", "J");
            morseMap.put("-.-", "k");
            morseMap.put(".-..", "L");
            morseMap.put("--", "M");
            morseMap.put("-.", "N");
            morseMap.put("---", "O");
            morseMap.put(".--.", "P");
            morseMap.put("--.-", "Q");
            morseMap.put(".-.", "R");
            morseMap.put("...", "S");
            morseMap.put("-", "T");
            morseMap.put("..-", "U");
            morseMap.put("...-", "V");
            morseMap.put(".--", "W");
            morseMap.put("-..-", "X");
            morseMap.put("-.--", "Y");
            morseMap.put("--..", "Z");

            morseMap.put(".----", "1");
            morseMap.put("..---", "2");
            morseMap.put("...--", "3");
            morseMap.put("....-", "4");
            morseMap.put(".....", "5");
            morseMap.put("-....", "6");
            morseMap.put("--...", "7");
            morseMap.put("---..", "8");
            morseMap.put("----.", "9");
            morseMap.put("-----", "0");

            morseMap.put("..--..", "?");
            morseMap.put("-.-.--", "!");
            morseMap.put(".-.-.-", ".");
            morseMap.put("--..--", ",");
        }

        if (letraMap.isEmpty()) {
            letraMap.put("A", ".-");
            letraMap.put("B", "-...");
            letraMap.put("C", "-.-.");
            letraMap.put("D", "-..");
            letraMap.put("E", ".");
            letraMap.put("F", "..-.");
            letraMap.put("G", "--.");
            letraMap.put("H", "....");
            letraMap.put("I", "..");
            letraMap.put("J", ".---");
            letraMap.put("K", "-.-");
            letraMap.put("L", ".-..");
            letraMap.put("M", "--");
            letraMap.put("N", "-.");
            letraMap.put("O", "---");
            letraMap.put("P", ".--.");
            letraMap.put("Q", "--.-");
            letraMap.put("R", ".-.");
            letraMap.put("S", "...");
            letraMap.put("T", "-");
            letraMap.put("U", "..-");
            letraMap.put("V", "...-");
            letraMap.put("W", ".--");
            letraMap.put("X", "-..-");
            letraMap.put("Y", "-.--");
            letraMap.put("Z", "--..");
            letraMap.put("1", ".----");
            letraMap.put("2", "..---");
            letraMap.put("3", "...--");
            letraMap.put("4", "....-");
            letraMap.put("5", ".....");
            letraMap.put("6", "-....");
            letraMap.put("7", "--...");
            letraMap.put("8", "---..");
            letraMap.put("9", "----.");
            letraMap.put("0", "-----");
            letraMap.put("?", "..--..");
            letraMap.put("!", "-.-.--");
            letraMap.put(".", ".-.-.-");
            letraMap.put(",", "--..--");
        }
    }

    public CodigoMorseService() {
        IniciarMorseMaps();
    }

    public String decifrar(String codigo) {

        StringBuilder res = new StringBuilder();
        List<String> listPalabras = Arrays.stream(codigo.split(" {3}")).toList();

        if (listPalabras.isEmpty()) {
            return "No hay palabras.";
        }

        for (String palabra : listPalabras) {
            List<String> letrasCifrada = Arrays.stream(palabra.split(" ")).toList();

            for (String letra : letrasCifrada) {
                res.append(morseMap.get(letra));
            }
            res.append(" ");
        }

        return res.toString();
    }

    public String cifrar(String frase) {

        StringBuilder res = new StringBuilder();
        List<String> listPalabras = Arrays.stream(frase.split(" ")).toList();

        if (listPalabras.isEmpty()) {
            return "No hay palabras.";
        }

        for (String palabra : listPalabras) {
            List<String> letras = Arrays.stream(palabra.split("")).toList();

            for (String letra : letras) {
                res.append(letraMap.get(letra)).append(" ");
            }
            res.append("  ");
        }

        return res.toString();
    }
}
