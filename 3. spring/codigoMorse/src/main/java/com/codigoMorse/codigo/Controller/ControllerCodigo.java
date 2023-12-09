package com.codigoMorse.codigo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ControllerCodigo {
    Map<String, String> mapaTraductor = new HashMap<String, String>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.","C");
        put("-..","D");
        put(".","E");
        put("--.-","F");
        put("--.","G");
        put("....","H");
        put("..", "I");
        put(".---","J");
        put("-.-","K");
        put(".-..","L");
        put("--","M");
        put("-.","N");
        put("---","O");
        put(".--.","P");
        put("--.-","Q");
        put(".-.","R");
        put("...","S");
        put("-","T");
        put("..-","U");
        put("...-","V");
        put(".--","W");
        put("-..-","X");
        put("-.--","Y");
        put("--..","Z");
        put(".----","1");
        put("..---","2");
        put("...--","3");
        put("....-","4");
        put(".....","5");
        put("-....","6");
        put("--...","7");
        put("---..","8");
        put("----.","9");
        put("-----","0");
        put("..--..","?");
        put("-.-.--","!");
        put(".-.-.-",".");
        put("--..--",",");
    }};

    @GetMapping("/traducirAEspanol")
    public String traducir(@RequestParam String texto) {
        String[] palabras = texto.split("   ");
        StringBuilder resultado = new StringBuilder();

        for(String palabra : palabras){
            String[] letras = palabra.split(" ");
            for(String letra : letras){
                String caracter = mapaTraductor.get(letra);
                resultado.append(caracter);
            }
            resultado.append(" ");
        }

        return resultado.toString().toUpperCase();
    }

    @GetMapping("/traducirAMorse")
    public String inverso(@RequestParam String texto) {
        StringBuilder morseText = new StringBuilder();
        String[] palabras = texto.split(" ");

        for(String palabra : palabras) {
            for (char spanishChar : palabra.toCharArray()) {
                for (Map.Entry<String, String> entry : mapaTraductor.entrySet()) {
                    if (entry.getValue().equals(String.valueOf(spanishChar).toUpperCase())) {
                        morseText.append(entry.getKey()).append(" ");
                        break;
                    }
                }
            }
            morseText.append("  ");
        }
        return morseText.toString().trim();
    }
}
