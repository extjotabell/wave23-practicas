package com.spring.codigoMorse.entities;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class MorseCode {
    private static final HashMap<String, String> morseCodeMap = new HashMap<>();
    private static final HashMap<String, String> reverseMorseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2" );
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6" );
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");

        for (String key : morseCodeMap.keySet()) {
            String value = morseCodeMap.get(key);
            reverseMorseCodeMap.put(value, key);
        }
    }

    public String morseToText(String message) {
        String[] characters = Arrays.stream(message.split(" "))
                .map(morseCodeMap::get).toArray(String[]::new);

        return String.join("", characters);
    }

    public String textToMorse(String message) {
        String[] characters = Arrays.stream(message.toUpperCase().split(""))
                .map(reverseMorseCodeMap::get).toArray(String[]::new);

        return String.join(" ", characters);
    }

}
