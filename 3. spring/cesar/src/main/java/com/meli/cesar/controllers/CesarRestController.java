package com.meli.cesar.controllers;

import com.meli.cesar.entities.CesarHelpers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/")
public class CesarRestController {

    @GetMapping("/23/{text}")
    public String cesar23(@PathVariable String text) {

        // Process text before moving letters
        String[] letters = CesarHelpers.processText(text);

        // Move letters according to the key (23)
        for (int i = 0; i < letters.length; i++) {
            // Get index of letter in alphabet
            int index = Arrays.asList(CesarHelpers.ALPHABET).indexOf(letters[i]);
            if (index == -1) return "Error: Invalid character";

            // Move letter depending on its position in the text
            if (((i + 1) % 2) == 0)
                index = (index + 3) % CesarHelpers.ALPHABET_LENGTH;
            else
                index = (index + 2) % CesarHelpers.ALPHABET_LENGTH;

            // Replace letter with new letter
            letters[i] = CesarHelpers.ALPHABET[index];
        }

        return String.join("", letters);
    }

    @GetMapping("/012/{text}")
    public String cesar012(@PathVariable String text) {

        // Process text before moving letters
        String[] letters = CesarHelpers.processText(text);

        int aux = 0;
        // Move letters according to the key (012)
        for (int i = 0; i < letters.length; i++) {
            // Get index of letter in alphabet
            int index = Arrays.asList(CesarHelpers.ALPHABET).indexOf(letters[i]);
            if (index == -1) return "Error: Invalid character";

            // Move letter depending on its position in the text
            if (aux == 2)
                index = (index + 2) % CesarHelpers.ALPHABET_LENGTH;
            else if (aux == 1)
                index = (index + 1) % CesarHelpers.ALPHABET_LENGTH;

            // Replace letter with new letter
            letters[i] = CesarHelpers.ALPHABET[index];

            // Move aux to next position
            aux = (aux + 1) % 3;
        }

        return String.join("", letters);
    }
}
