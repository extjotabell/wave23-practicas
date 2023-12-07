package com.mercadolibre.morseCode.service;

import com.mercadolibre.morseCode.exception.InvalidMessageException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for encoding and decoding Morse code messages.
 */
@Service
public class MorseCodeService {

    private static final Map<String, String> library = new HashMap<String, String>();
    static {
        // Morse code library mapping characters to Morse code representations
        library.put(".-", "A");
        library.put("-...", "B");
        library.put("-.-.", "C");
        library.put("-..", "D");
        library.put(".", "E");
        library.put("..-.", "F");
        library.put("--.", "G");
        library.put("....", "H");
        library.put("..", "I");
        library.put(".---", "J");
        library.put("-.-", "K");
        library.put(".-..", "L");
        library.put("--", "M");
        library.put("-.", "N");
        library.put("---", "O");
        library.put(".--.", "P");
        library.put("--.-", "Q");
        library.put(".-.", "R");
        library.put("...", "S");
        library.put("-", "T");
        library.put("..-", "U");
        library.put("...-", "V");
        library.put(".--", "W");
        library.put("-..-", "X");
        library.put("-.--", "Y");
        library.put("--..", "Z");
        library.put(".----", "1");
        library.put("..---", "2");
        library.put("...--", "3");
        library.put("....-", "4");
        library.put(".....", "5");
        library.put("-....", "6");
        library.put("--...", "7");
        library.put("---..", "8");
        library.put("----.", "9");
        library.put("-----", "0");
    }

    /**
     * Encodes a plain text message into Morse code.
     *
     * @param message The plain text message to be encoded.
     * @return The encoded Morse code representation of the input message.
     * @throws InvalidMessageException If the message contains invalid characters.
     */
    public String encode(String message){
        message = message.toUpperCase();

        if(!isValid(message)){
            throw new InvalidMessageException("El mensaje no puede contener caracteres especiales.");
        }

        StringBuilder encode = new StringBuilder();
        String [] splitWords =  message.split(" ");

        for (String word: splitWords){
            for (Character letter: word.toCharArray()){
                String letterEncode = getLetterAssoc(letter.toString());
                encode.append(letterEncode);
                encode.append(" ");
            }
            encode.append("  ");
        }
        return encode.toString().trim();
    }

    /**
     * Decodes a Morse code message into plain text.
     *
     * @param message The Morse code message to be decoded.
     * @return The decoded plain text representation of the input Morse code message.
     */
    public String decode(String message) {
        StringBuilder decode = new StringBuilder();
        String [] splitWords =  message.split("   ");

        for (String word: splitWords){
            String [] splitLetter = word.split(" ");
            for (String letter: splitLetter){
                String letterDecode = library.get(letter);
                decode.append(letterDecode);
            }
            decode.append(" ");
        }

        System.out.println(Arrays.toString(splitWords));
        System.out.println(splitWords[0]);
        return decode.toString().trim();
    }

    /**
     * Checks if the provided message contains only valid characters for Morse code encoding.
     *
     * @param message The message to be validated.
     * @return True if the message contains only letters, digits, and spaces; false otherwise.
     */
    private boolean isValid(String message) {
        return message.matches("[a-zA-Z0-9\\s]+");
    }

    /**
     * Retrieves the Morse code representation associated with the given letter.
     *
     * @param letter The letter for which the Morse code representation is needed.
     * @return The Morse code representation of the input letter.
     */
    private String getLetterAssoc(String letter){
        String letterAssoc = "";
        for (Map.Entry<String, String> entry : library.entrySet()) {
            if (entry.getValue().equals(letter)) {
                letterAssoc = entry.getKey();
            }
        }
        
        return letterAssoc;
    }

}
