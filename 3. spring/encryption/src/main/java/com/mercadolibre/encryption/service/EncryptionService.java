package com.mercadolibre.encryption.service;

import com.mercadolibre.encryption.entity.EncryptResult;
import org.springframework.stereotype.Service;

/**
 * Service class for message encryption using the Caesar cipher.
 */
@Service
public class EncryptionService {

    /**
     * Encrypts the given text using both key '23' and the provided key.
     *
     * @param text The text to be encrypted.
     * @param key  The encryption key provided by the user.
     * @return An EncryptResult object containing the encrypted message using key '23' and the provided key.
     */
    public EncryptResult encrypt(String text, String key) {
        String encryptedMessage = encryptMessage(text, key);
        return new EncryptResult(encryptMessage(text, "23"), encryptedMessage);
    }

    /**
     * Encrypts a message using the Caesar cipher.
     *
     * @param text The message to be encrypted.
     * @param key  The encryption key.
     * @return The encrypted message.
     */
    private String encryptMessage(String text, String key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return text.chars()
                .mapToObj(c -> encryptLetter((char) c, alphabet, key))
                .reduce("", String::concat);
    }

    /**
     * Encrypts a single letter using the Caesar cipher.
     *
     * @param letter   The letter to be encrypted.
     * @param alphabet The alphabet used for encryption.
     * @param key      The encryption key.
     * @return The encrypted letter.
     */
    private String encryptLetter(char letter, String alphabet, String key) {
        if (!Character.isAlphabetic(letter)) {
            return String.valueOf(letter);
        }

        int shift = Integer.parseInt(key.substring(0, 1));
        int currentPos = alphabet.indexOf(Character.toUpperCase(letter));
        int newPos = (currentPos + shift) % 26;

        return Character.isUpperCase(letter) ? String.valueOf(alphabet.charAt(newPos)) :
                String.valueOf(alphabet.charAt(newPos)).toLowerCase();
    }
}