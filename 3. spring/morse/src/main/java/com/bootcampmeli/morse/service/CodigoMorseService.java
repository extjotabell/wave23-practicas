package com.bootcampmeli.morse.service;

import java.util.*;

public class CodigoMorseService {
    private Map<String, String> morseLetterMap = new HashMap<>();
    private Map<String, String> letterMorseMap = new HashMap<>();

    public Map<String, String> getLetterMorseMap() {
        if(letterMorseMap.isEmpty()){
            letterMorseMap.put("A", ".-");
            letterMorseMap.put("B", "-...");
            letterMorseMap.put("C", "-.-.");
            letterMorseMap.put("D", "-..");
            letterMorseMap.put("E", ".");
            letterMorseMap.put("F", "..-.");
            letterMorseMap.put("G", "--.");
            letterMorseMap.put("H", "....");
            letterMorseMap.put("I", "..");
            letterMorseMap.put("J", ".---");
            letterMorseMap.put("K", "-.-");
            letterMorseMap.put("L", ".-..");
            letterMorseMap.put("M", "--");
            letterMorseMap.put("N", "-.");
            letterMorseMap.put("O", "---");
            letterMorseMap.put("P", ".--.");
            letterMorseMap.put("Q", "--.-");
            letterMorseMap.put("R", ".-.");
            letterMorseMap.put("S", "...");
            letterMorseMap.put("T", "-");
            letterMorseMap.put("U", "..-");
            letterMorseMap.put("V", "...-");
            letterMorseMap.put("W", ".--");
            letterMorseMap.put("X", "-..-");
            letterMorseMap.put("Y", "-.--");
            letterMorseMap.put("Z", "--..");
            letterMorseMap.put("1", ".----");
            letterMorseMap.put("2", "..---");
            letterMorseMap.put("3", "...--");
            letterMorseMap.put("4", "....-");
            letterMorseMap.put("5", ".....");
            letterMorseMap.put("6", "-....");
            letterMorseMap.put("7", "--...");
            letterMorseMap.put("8", "---..");
            letterMorseMap.put("9", "----.");
            letterMorseMap.put("0", "-----");
            letterMorseMap.put("?", "..--..");
            letterMorseMap.put("!", "-.-.--");
            letterMorseMap.put(".", ".-.-.-");
            letterMorseMap.put(",", "--..--");
            letterMorseMap.put(" ", "   ");
        }
        return letterMorseMap;
    }

    public Map<String, String> getMorseLetterMap() {
        if(morseLetterMap.isEmpty()){
            morseLetterMap.put(".-", "A");
            morseLetterMap.put("-...", "B");
            morseLetterMap.put("-.-.", "C");
            morseLetterMap.put("-..", "D");
            morseLetterMap.put(".", "E");
            morseLetterMap.put("..-.", "F");
            morseLetterMap.put("--.", "G");
            morseLetterMap.put("....", "H");
            morseLetterMap.put("..", "I");
            morseLetterMap.put(".---", "J");
            morseLetterMap.put("-.-", "K");
            morseLetterMap.put(".-..", "L");
            morseLetterMap.put("--", "M");
            morseLetterMap.put("-.", "N");
            morseLetterMap.put("---", "O");
            morseLetterMap.put(".--.", "P");
            morseLetterMap.put("--.-", "Q");
            morseLetterMap.put(".-.", "R");
            morseLetterMap.put("...", "S");
            morseLetterMap.put("-", "T");
            morseLetterMap.put("..-", "U");
            morseLetterMap.put("...-", "V");
            morseLetterMap.put(".--", "W");
            morseLetterMap.put("-..-", "X");
            morseLetterMap.put("-.--", "Y");
            morseLetterMap.put("--..", "Z");
            morseLetterMap.put(".----", "1");
            morseLetterMap.put("..---", "2");
            morseLetterMap.put("...--", "3");
            morseLetterMap.put("....-", "4");
            morseLetterMap.put(".....", "5");
            morseLetterMap.put("-....", "6");
            morseLetterMap.put("--...", "7");
            morseLetterMap.put("---..", "8");
            morseLetterMap.put("----.", "9");
            morseLetterMap.put("-----", "0");
            morseLetterMap.put("..--..", "?");
            morseLetterMap.put("-.-.--", "!");
            morseLetterMap.put(".-.-.-", ".");
            morseLetterMap.put("--..--", ",");
            morseLetterMap.put("   ", " ");
        }
        return morseLetterMap;
    }

    public String descifrarFrase(String frase){
        List<String> listPalabras = Arrays.stream(frase.split(" {3}")).toList();
        StringBuilder res = new StringBuilder();

        for(String palabra: listPalabras){
            List<String> listLetras = Arrays.stream(palabra.split(" ")).toList();
            for(String letra : listLetras){
                res.append(getMorseLetterMap().get(letra));
            }
            res.append("  ");
        }

        return res.toString();
    }

    public String cifrarFrase(String frase){
        List<String> listPalabras = Arrays.stream(frase.split(" ")).toList();
        StringBuilder res = new StringBuilder();

        for(String palabra: listPalabras){
            List<String> listLetras = Arrays.stream(palabra.split("")).toList();
            for(String letra : listLetras){
                res.append(getLetterMorseMap().get(letra)).append(" ");
            }
            res.append("  ");
        }

        return res.toString();
    }

}
