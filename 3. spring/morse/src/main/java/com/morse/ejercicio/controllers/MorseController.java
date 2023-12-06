package com.morse.ejercicio.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/morse")
public class MorseController {

    Map<String, String> codigoMorseMapa = new HashMap<String, String>() {{
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
    }};

    @PostMapping("/traducir")
    public String traducirDeMorse(@RequestBody String mensaje) {
        return obtenerMensajeTraducido(mensaje);
    }

    private String obtenerMensajeTraducido(String mensaje) {
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.asList(mensaje.split("   "));

        palabras.forEach(palabra -> {
            String[] letras = palabra.split(" ");
            Arrays.stream(letras).forEach(letra -> {
                String letraObtenida = obtenerLetra(letra);
                resultado.append(letraObtenida);
            });
            resultado.append(" ");
        });
        return resultado.toString().trim();
    }

    private String obtenerLetra(String letra) {
        String resultado = null;
        for (Map.Entry<String, String> mapa : codigoMorseMapa.entrySet()) {
            if (mapa.getValue().equals(letra)) {
                resultado = mapa.getKey();
                return resultado;
            } else if (mapa.getKey().equals(letra)){
                resultado = mapa.getValue() + " ";
                return resultado;
            }
        }
        return resultado;
    }
}
