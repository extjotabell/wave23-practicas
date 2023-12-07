package com.meli.morsecode.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeService {

    Map<String, String> equivalences;

    public MorseCodeService() {
        equivalences = new HashMap<>();
        equivalences.put(".-", "A");
        equivalences.put("-...", "B");
        equivalences.put("-.-.", "C");
        equivalences.put("-..", "D");
        equivalences.put(".", "E");
        equivalences.put("..-.", "F");
        equivalences.put("--.", "G");
        equivalences.put("....", "H");
        equivalences.put("..", "I");
        equivalences.put(".---", "J");
        equivalences.put("-.-", "K");
        equivalences.put(".-..", "L");
        equivalences.put("--", "M");
        equivalences.put("-.", "N");
        equivalences.put("---", "O");
        equivalences.put(".--.", "P");
        equivalences.put("--.-", "Q");
        equivalences.put(".-.", "R");
        equivalences.put("...", "S");
        equivalences.put("-", "T");
        equivalences.put("..-", "U");
        equivalences.put("...-", "V");
        equivalences.put(".--", "W");
        equivalences.put("-..-", "X");
        equivalences.put("-.--", "Y");
        equivalences.put("--..", "Z");
        equivalences.put(".----", "1");
        equivalences.put("..---", "2");
        equivalences.put("...--", "3");
        equivalences.put("....-", "4");
        equivalences.put(".....", "5");
        equivalences.put("-....", "6");
        equivalences.put("--...", "7");
        equivalences.put("---..", "8");
        equivalences.put("----.", "9");
        equivalences.put("-----", "0");
        equivalences.put("..--..", "?");
        equivalences.put("-.-.--", "!");
        equivalences.put(".-.-.-", ".");
        equivalences.put("--..--", ",");
    }

    public String decode(String code){
        StringBuilder result = new StringBuilder();
        String[] words = code.split("   ");
        for (String word  : words){
            String[] letters = word.split(" ");
            for (String letter: letters){
                String wordFound = "";
                String letterFound = equivalences.get(letter);
                wordFound = wordFound + letterFound;
                result.append(wordFound);
            }
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    public String encode(String message){
        StringBuilder result = new StringBuilder();
        message = message.toUpperCase();
        String[] words = message.split(" ");
        for (String word  : words){
            String[] letters = word.split("");
            for (String letter: letters){
                String wordFound ="";
                String letterFound = getKeysByValue(letter);
                wordFound = wordFound + letterFound + " ";
                result.append(wordFound);
            }
            result = result.append("  ");
        }
        result.delete(result.length()-3,result.length());
        return result.toString();
    }

    private String getKeysByValue(String value) {
        return equivalences.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value) )
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
