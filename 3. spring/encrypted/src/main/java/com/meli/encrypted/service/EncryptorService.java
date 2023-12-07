package com.meli.encrypted.service;

import com.meli.encrypted.exception.EncyptorException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EncryptorService {

    private Map<Integer, Integer[]> defaultKeys;
    private List<Character> alphabet;

    public EncryptorService(){
        defaultKeys = new HashMap<>();
        defaultKeys.put(2, new Integer[]{2, 3});
        alphabet = new ArrayList<>();

        for (char letra = 'A'; letra <= 'Z'; letra++) alphabet.add(letra);
    }

    public String encryptKeyDefault(String sentence) throws EncyptorException {
        this.validateString(sentence);
        Integer[] movements = defaultKeys.get(2);
        sentence = sentence.toUpperCase().replace(" ","");
        return encryptKey(sentence,movements);
    }

    public String encryptKey(String sentence, Integer [] movements) throws EncyptorException {
        validateString(sentence);

        String encryptedSentence = "";
        sentence = sentence.toUpperCase().replace(" ","");
        int movement = movements[0];
        int indexMovement = 0;

        for (int n = 0; n < sentence.length (); n++){
            char letter = sentence.charAt(n);
            int indexLetters = (alphabet.indexOf(letter) + movement) % alphabet.size();
            char newLetter =   alphabet.get(indexLetters);
            movement = getNextMove(indexMovement, movements);
            encryptedSentence += newLetter;
            indexMovement = indexMovement >= movements.length - 1 ? 0 : indexMovement + 1;
        }
        return encryptedSentence;
    }
    private void validateString(String sentence) throws EncyptorException {
        if ( sentence.matches(".*[0-9].*") )throw new EncyptorException(EncyptorException.STRING_WITH_NUMBERS_EXCEPTION);
    }
    private Integer getNextMove(int index,Integer[] movements){
        return index < movements.length-1 ?  movements[index+1] : movements[0];
    }



}
