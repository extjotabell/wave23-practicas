package com.codigoMorse.codigoMorse.service;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseServicio {

    private static final Map<String, String> morseMap = new HashMap<>();

    static {
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
        morseMap.put("-.-", "K");
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
        morseMap.put("   ", " ");
    }

    public String convertirAEspanol(String morse) {
        String[] words = morse.split("   ");
        StringBuilder spanishText = new StringBuilder();

        for (String word : words) {
            String[] morseChars = word.split(" ");
            for (String morseChar : morseChars) {
                if (morseMap.containsKey(morseChar)) {
                    spanishText.append(morseMap.get(morseChar));
                } else {
                    spanishText.append(morseChar);
                }
            }
            spanishText.append(" ");
        }
        return spanishText.toString();
    }

    public String convertirAMorse(String espanol) {
        StringBuilder morseText = new StringBuilder();
        String[] palabras = espanol.split(" ");

        for(String palabra : palabras) {
            for (char spanishChar : palabra.toCharArray()) {
                for (Map.Entry<String, String> entry : morseMap.entrySet()) {
                    if (entry.getValue().equals(String.valueOf(spanishChar).toUpperCase())) {
                        morseText.append(entry.getKey()).append(" ");
                        break;
                    }
                }
            }
            morseText.append("  ");
        }
        return morseText.toString().trim();
    }
}
