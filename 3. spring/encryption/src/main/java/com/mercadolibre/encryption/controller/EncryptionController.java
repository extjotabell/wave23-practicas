package com.mercadolibre.encryption.controller;

import com.mercadolibre.encryption.model.EncryptRequest;
import com.mercadolibre.encryption.model.EncryptResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encryption")
public class EncryptionController {
    // Endpoint to handle POST requests for message encryption
    @PostMapping(value = "/encrypt", consumes = "text/plain;charset=UTF-8", produces = "text/plain;charset=UTF-8")
    public EncryptResult encrypt(@RequestBody EncryptRequest request) {
        String text = request.getText();
        String key = request.getKey();

        // Encrypt the message using both key '23' and the provided key
        String encryptedMessage23 = encryptMessage(text, "23");
        String encryptedMessage012 = encryptMessage(text, key);

        // Return the encrypted messages
        return new EncryptResult(encryptedMessage23, encryptedMessage012);
    }
    // Method to encrypt a message using the Caesar cipher
    private String encryptMessage(String text, String key) {
        // Define the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Use Stream API to iterate over each character in the text and apply the encryption
        return text
                .chars()
                .mapToObj(c -> encryptLetter((char) c, alphabet, key))
                .reduce("", String::concat);
    }
    // Method to encrypt a single letter using the Caesar cipher
    private String encryptLetter(char letter, String alphabet, String key) {
        // If the character is not an alphabetic character, return it unchanged
        if (!Character.isAlphabetic(letter)) {
            return String.valueOf(letter);
        }

        // Parse the first digit of the key for the shift value
        int shift = Integer.parseInt(key.substring(0, 1));
        // Find the current position of the letter in the alphabet
        int currentPos = alphabet.indexOf(Character.toUpperCase(letter));
        // Calculate the new position after applying the shift
        int newPos = (currentPos + shift) % 26;
        // Return the encrypted letter, preserving the case
        return Character.isUpperCase(letter) ? String.valueOf(alphabet.charAt(newPos)) :
                String.valueOf(alphabet.charAt(newPos)).toLowerCase();
    }
}
