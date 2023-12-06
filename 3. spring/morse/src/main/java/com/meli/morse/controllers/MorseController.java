package com.meli.morse.controllers;

import com.meli.morse.entities.MorseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MorseController {

    @GetMapping("/decrypt/")
    public String decrypt(@RequestParam String morseCode) {
        String[] words = morseCode.split("   ");
        StringBuilder result = new StringBuilder();

        for(String word : words) {
            String[] letters = word.split(" ");

            // Conseguir la letra del código morse
            for(String letter : letters) {
                result.append(MorseEntity.morseCode.get(letter));
            }

            // Espacio entre palabras
            result.append(" ");
        }

        // Quitamos el último espacio
        return result.toString().trim();
    }

    @GetMapping("/encrypt/")
    public String encrypt(@RequestParam String text) {
        String[] words = text.toUpperCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String[] letters = word.split("");

            for (String letter : letters) {
                // Conseguir el código morse de la letra
                result.append(MorseEntity.morseCode.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(letter))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(""));

                // Espacio entre letras
                result.append(" ");
            }

            // Espacio entre palabras (3 espacios, pero ya agregamos 1 arriba)
            result.append("  ");
        }

        // Quitamos el último espacio
        return result.toString().trim();
    }
}
