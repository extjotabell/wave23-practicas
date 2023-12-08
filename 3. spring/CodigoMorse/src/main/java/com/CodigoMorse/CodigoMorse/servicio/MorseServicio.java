package com.CodigoMorse.CodigoMorse.servicio;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MorseServicio {
    static BiMap<String,String > morseMap = HashBiMap.create();
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
       }


    public String convertir(String morse) {
        String[] words = morse.split(" {3}");
        StringBuilder spanishText = new StringBuilder();

        for (String word : words) {
            String[] morseChars = word.split(" ");
            for (String morseChar : morseChars) {
                // Si el código Morse no se encuentra en el mapa, se mantiene sin cambios
                spanishText.append(morseMap.getOrDefault(morseChar, "X"));
            }
            spanishText.append(" ");
        }
        return spanishText.toString();
    }

    public String inverso(String espanol) {
        StringBuilder morseText = new StringBuilder();

            for (char spanishChar : espanol.toUpperCase().toCharArray()) {
                if (Character.isSpaceChar(spanishChar)) morseText.append("  ");
                else {
                    morseText.append(morseMap.inverse().getOrDefault(String.valueOf(spanishChar), "X") + " ");
                }
            }

        return morseText.toString().trim();
    }
}
