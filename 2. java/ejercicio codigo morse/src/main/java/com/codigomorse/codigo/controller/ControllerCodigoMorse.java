package com.codigomorse.codigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ControllerCodigoMorse {

    @PostMapping("/transformarPalabra")
    public String transformarPalabra(@RequestBody String frase) {
        HashMap<String, String> codigoMorse = new HashMap<>();
        codigoMorse.put(".-", "A");
        codigoMorse.put("-...", "B");
        codigoMorse.put("-.-.", "C");
        codigoMorse.put("-..", "D");
        codigoMorse.put(".", "E");
        codigoMorse.put("..-.", "F");
        codigoMorse.put("--.", "G");
        codigoMorse.put("....", "H");
        codigoMorse.put("..", "I");
        codigoMorse.put(".---", "J");
        codigoMorse.put("-.-", "K");
        codigoMorse.put(".-..", "L");
        codigoMorse.put("--", "M");
        codigoMorse.put("-.", "N");
        codigoMorse.put("---", "O");
        codigoMorse.put(".--.", "P");
        codigoMorse.put("--.-", "Q");
        codigoMorse.put(".-.", "R");
        codigoMorse.put("...", "S");
        codigoMorse.put("-", "T");
        codigoMorse.put("..-", "U");
        codigoMorse.put("...-", "V");
        codigoMorse.put(".--", "W");
        codigoMorse.put("-..-", "X");
        codigoMorse.put("-.--", "Y");
        codigoMorse.put("--..", "Z");

        StringBuilder resultado = new StringBuilder();
        String[] palabras = frase.split("   ");

        for (String p : palabras) {
            String[] caracteres = p.split(" ");
            for (String caracter : caracteres) {
                if (codigoMorse.containsKey(caracter)) {
                    resultado.append(codigoMorse.get(caracter));
                } /*else {
                    resultado.append("Caracter no es morse");
                }*/
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}
