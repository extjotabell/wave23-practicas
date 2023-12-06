package com.example.ejercicio_codigo_morse.entities;

import java.util.HashMap;
import java.util.Map;

public class Morse {
    private static final Map<String, String> morseToSpanish = new HashMap<>();

    static {
        // Mapeo de letras del alfabeto español a su equivalente en código Morse
        morseToSpanish.put(".-", "A");
        morseToSpanish.put("-...", "B");
        morseToSpanish.put("-.-.", "C");
        morseToSpanish.put("-..", "D");
        morseToSpanish.put(".", "E");
        morseToSpanish.put("..-.", "F");
        morseToSpanish.put("--.", "G");
        morseToSpanish.put("....", "H");
        morseToSpanish.put("..", "I");
        morseToSpanish.put(".---", "J");
        morseToSpanish.put("-.-", "K");
        morseToSpanish.put(".-..", "L");
        morseToSpanish.put("--", "M");
        morseToSpanish.put("-.", "N");
        morseToSpanish.put("---", "O");
        morseToSpanish.put(".--.", "P");
        morseToSpanish.put("--.-", "Q");
        morseToSpanish.put(".-.", "R");
        morseToSpanish.put("...", "S");
        morseToSpanish.put("-", "T");
        morseToSpanish.put("..-", "U");
        morseToSpanish.put("...-", "V");
        morseToSpanish.put(".--", "W");
        morseToSpanish.put("-..-", "X");
        morseToSpanish.put("-.--", "Y");
        morseToSpanish.put("--..", "Z");
        morseToSpanish.put(".----","1");
        morseToSpanish.put("..---","2");
        morseToSpanish.put("...--","3");
        morseToSpanish.put("....-","4");
        morseToSpanish.put(".....","5");
        morseToSpanish.put("-....","6");
        morseToSpanish.put("--...","7");
        morseToSpanish.put("---..","8");
        morseToSpanish.put("----.","9");
        morseToSpanish.put("-----","0");
        morseToSpanish.put("..--..","?");
        morseToSpanish.put("-.-.--","!");
        morseToSpanish.put(".-.-.-",".");
        morseToSpanish.put("--..--",",");
    }

    public static String translateToSpanish(String morseCode) {
        // Divide el código Morse en palabras separadas por tres espacios y letras por un espacio
        String[] words = morseCode.split("\\s{3}");

        // Traduce cada palabra de código Morse a español
        StringBuilder spanishText = new StringBuilder();
        for (String word : words) {
            // Divide cada palabra en letras separadas por un espacio
            String[] letters = word.split("\\s");
            for (String letter : letters) {
                if (morseToSpanish.containsKey(letter)) {
                    spanishText.append(morseToSpanish.get(letter));
                } else {
                    // Si el código Morse no se encuentra en el mapa, se mantiene sin cambios
                    spanishText.append(letter);
                }
            }
            // Agrega un espacio entre las palabras traducidas
            spanishText.append(" ");
        }

        return spanishText.toString().trim(); // Elimina el espacio adicional al final
    }
}
