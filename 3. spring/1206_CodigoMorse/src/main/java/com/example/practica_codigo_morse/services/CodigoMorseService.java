package com.example.practica_codigo_morse.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService {

    private static final HashMap<String, String> morseATextoMap = new HashMap<>();
    private static final HashMap<String, String> textoAMorseMap = new HashMap<>();


    static {
        morseATextoMap.put(".-", "A");
        morseATextoMap.put("-...", "B");
        morseATextoMap.put("-.-.", "C");
        morseATextoMap.put("-..", "D");
        morseATextoMap.put(".", "E");
        morseATextoMap.put("..-.", "F");
        morseATextoMap.put("--.", "G");
        morseATextoMap.put("....", "H");
        morseATextoMap.put("..", "I");
        morseATextoMap.put(".---", "J");
        morseATextoMap.put("-.-", "K");
        morseATextoMap.put(".-..", "L");
        morseATextoMap.put("--", "M");
        morseATextoMap.put("-.", "N");
        morseATextoMap.put("---", "O");
        morseATextoMap.put(".--.", "P");
        morseATextoMap.put("--.-", "Q");
        morseATextoMap.put(".-.", "R");
        morseATextoMap.put("...", "S");
        morseATextoMap.put("-", "T");
        morseATextoMap.put("..-", "U");
        morseATextoMap.put("...-", "V");
        morseATextoMap.put(".--", "W");
        morseATextoMap.put("-..-", "X");
        morseATextoMap.put("-.--", "Y");
        morseATextoMap.put("--..", "Z");
        morseATextoMap.put(".----", "1");
        morseATextoMap.put("..---", "2" );
        morseATextoMap.put("...--", "3");
        morseATextoMap.put("....-", "4");
        morseATextoMap.put(".....", "5");
        morseATextoMap.put("-....", "6" );
        morseATextoMap.put("--...", "7");
        morseATextoMap.put("---..", "8");
        morseATextoMap.put("----.", "9");
        morseATextoMap.put("-----", "0");
        morseATextoMap.put("..--..", "?");
        morseATextoMap.put("-.-.--", "!");
        morseATextoMap.put(".-.-.-", ".");
        morseATextoMap.put("--..--", ",");

        for (String key : morseATextoMap.keySet()) {
            String value = morseATextoMap.get(key);
            textoAMorseMap.put(value, key);
        }

    }

    public String morseATexto(String mensaje) {
        String[] caracteres = Arrays.stream(mensaje.split(" "))
                .map(morseATextoMap::get).toArray(String[]::new);

        return String.join("", caracteres);
    }

    public String textoAMorse(String mensaje) {
        String[] caracteres = Arrays.stream(mensaje.split(""))
                .map(textoAMorseMap::get).toArray(String[]::new);

        return String.join(" ", caracteres);
    }
}
