package com.pasajeAMorse.morse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api")
public class MorseController {

    private static final Map<Character, String> codigoMorse = new HashMap<>();

    static {
        codigoMorse.put('A', ".-");
        codigoMorse.put('B', "-...");
        codigoMorse.put('C', "-.-.");
        codigoMorse.put('D', "-..");
        codigoMorse.put('E', ".");
        codigoMorse.put('F', "..-.");
        codigoMorse.put('G', "--.");
        codigoMorse.put('H', "....");
        codigoMorse.put('I', "..");
        codigoMorse.put('J', ".---");
        codigoMorse.put('K', "-.-");
        codigoMorse.put('L', ".-..");
        codigoMorse.put('M', "--");
        codigoMorse.put('N', "-.");
        codigoMorse.put('O', "---");
        codigoMorse.put('P', ".--.");
        codigoMorse.put('Q', "--.-");
        codigoMorse.put('R', ".-.");
        codigoMorse.put('S', "...");
        codigoMorse.put('T', "-");
        codigoMorse.put('U', "..-");
        codigoMorse.put('V', "...-");
        codigoMorse.put('W', ".--");
        codigoMorse.put('X', "-..-");
        codigoMorse.put('Y', "-.--");
        codigoMorse.put('Z', "--..");
        codigoMorse.put('1', ".----");
        codigoMorse.put('2', "..---");
        codigoMorse.put('3', "...--");
        codigoMorse.put('4', "....-");
        codigoMorse.put('5', ".....");
        codigoMorse.put('6', "-....");
        codigoMorse.put('7', "--...");
        codigoMorse.put('8', "---..");
        codigoMorse.put('9', "----.");
        codigoMorse.put('0', "-----");
        codigoMorse.put('?', "..--..");
        codigoMorse.put('!', "-.-.--");
        codigoMorse.put('.', ".-.-.-");
        codigoMorse.put(',', "--..--");
    }

    @GetMapping("/codificar")
    public String codificar(@RequestBody String mensaje) {
        String mensajeMayuscula = mensaje.toUpperCase();
        String mensajeEnMorse = "";
        char caracterAConvertir;

        for (int i = 0; i < mensajeMayuscula.length(); i++) {
            caracterAConvertir = mensajeMayuscula.charAt(i);

            if (caracterAConvertir == ' ') {
                mensajeEnMorse = mensajeEnMorse.concat("  ");
            }
            else {
                mensajeEnMorse = mensajeEnMorse.concat(codigoMorse.get(caracterAConvertir) + " ");
            }
        }

        return "Texto: " + mensaje + "\n" + "Morse: " + mensajeEnMorse.trim();
    }

    @GetMapping("/decodificar")
    public String decodificar(@RequestBody String mensaje) {
        List<String> palabras = new ArrayList<>();
        List<String> letras = new ArrayList<>();
        String mensajeTexto = "";

        palabras = List.of(mensaje.split("   "));

        for (String palabra : palabras) {
            letras = List.of(palabra.split(" "));

            for (String letra : letras) {

                for (Map.Entry<Character, String> entry : codigoMorse.entrySet()) {
                    if (Objects.equals(entry.getValue(), letra)) {
                        mensajeTexto = mensajeTexto.concat(String.valueOf(entry.getKey()));
                        break;
                    }
                }

            }

            mensajeTexto = mensajeTexto.concat(" ");
        }

        return "Morse: " + mensaje + "\n" + "Texto: " + mensajeTexto;
    }

}
