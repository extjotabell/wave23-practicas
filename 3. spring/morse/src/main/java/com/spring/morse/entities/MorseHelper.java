package com.spring.morse.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseHelper {
    private static final HashMap<String, Character> codigosMorse = new HashMap<>();

    static {
        codigosMorse.put(".-", 'A');
        codigosMorse.put("-...", 'B');
        codigosMorse.put("-.-.", 'C');
        codigosMorse.put("-..", 'D');
        codigosMorse.put(".", 'E');
        codigosMorse.put("..-.", 'F');
        codigosMorse.put("--.", 'G');
        codigosMorse.put("....", 'H');
        codigosMorse.put("..", 'I');
        codigosMorse.put(".---", 'J');
        codigosMorse.put("-.-", 'K');
        codigosMorse.put(".-..", 'L');
        codigosMorse.put("--", 'M');
        codigosMorse.put("-.", 'N');
        codigosMorse.put("---", 'O');
        codigosMorse.put(".--.", 'P');
        codigosMorse.put("--.-", 'Q');
        codigosMorse.put(".-.", 'R');
        codigosMorse.put("...", 'S');
        codigosMorse.put("-", 'T');
        codigosMorse.put("..-", 'U');
        codigosMorse.put("...-", 'V');
        codigosMorse.put(".--", 'W');
        codigosMorse.put("-..-", 'X');
        codigosMorse.put("-.--", 'Y');
        codigosMorse.put("--..", 'Z');
        codigosMorse.put(".----", '1');
        codigosMorse.put("..---", '2');
        codigosMorse.put("...--", '3');
        codigosMorse.put("....-", '4');
        codigosMorse.put(".....", '5');
        codigosMorse.put("-....", '6');
        codigosMorse.put("--...", '7');
        codigosMorse.put("---..", '8');
        codigosMorse.put("----.", '9');
        codigosMorse.put("-----", '0');
        codigosMorse.put("..--..", '?');
        codigosMorse.put("-.-.--", '!');
        codigosMorse.put(".-.-.-", '.');
        codigosMorse.put("--..--", ',');

    }

    public Character getCharacterFromMorse(String codigo){
        return codigosMorse.get(codigo);
    }

    public static String getWordFromMorseWord(String morseWord){
        List<String> morseLetters = List.of(morseWord.split(" "));

        StringBuilder cadena = new StringBuilder();

        for(String morseLetter: morseLetters){
            Character letraABC = codigosMorse.get(morseLetter);
            cadena.append(letraABC.toString());
        }
        return cadena.toString();
    }

    public static String getSentenceFromMorseSentence(String morseSentence){
        List<String> morseWords = List.of(morseSentence.split("   "));

        StringBuilder sentencia = new StringBuilder();
        for(String morseWord: morseWords){
            String palabraABC = getWordFromMorseWord(morseWord);
            sentencia.append(palabraABC + " ");
        }
        return sentencia.toString().trim();
    }
    public static String getMorseWordFromWord(String word){

        StringBuilder morseCadena = new StringBuilder();
        for(Character letter: word.toCharArray()){
            String morseLetter="";
            for(Map.Entry<String, Character> entry: codigosMorse.entrySet()){
                if(entry.getValue() == letter) {
                    morseLetter = entry.getKey();
                }
            }
            morseCadena.append(morseLetter + " ");
        }
        return morseCadena.toString().trim();
    }
    public static String getMorseSentenceFromABCSentence(String sentence){
        List<String> words = List.of(sentence.split(" "));
        StringBuilder morseSentence = new StringBuilder();
        for(String word: words){
            String morseWord = getMorseWordFromWord(word.toUpperCase());
            morseSentence.append(morseWord + "   ");
        }
        return morseSentence.toString().trim();
    }
}
