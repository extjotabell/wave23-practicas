package com.mercadolibre.encriptador.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class EncriptadorController {
    String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    @GetMapping("/encriptar")
    public String encriptarN(@RequestParam String texto, @RequestParam int[] N) {
        return encriptar(texto, N);
    }

    @GetMapping("/desencriptar")
    public String desencriptarN(@RequestParam String texto, @RequestParam int[] N){
        return desencriptar(texto, N);
    }

    private int buscarIndice(String letra) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i].equals(letra)) {
                return i;
            }
        }
        throw new IllegalArgumentException("El caracter no es parte del alfabeto");
    }

    private String encriptar(String frase, int[] N){
        String textoSinEspacio = frase.replace(" ", "");
        textoSinEspacio = textoSinEspacio.toLowerCase();

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < textoSinEspacio.length(); i++) {
            String aux = String.valueOf(textoSinEspacio.charAt(i));

            int posicionalfabeto = buscarIndice(aux);
            int indexNuevo = 0;
            int indexN = i % N.length;

            if (alfabeto.length <= posicionalfabeto + N[indexN]) {
                indexNuevo = (posicionalfabeto + N[indexN]) - alfabeto.length;
            } else {
                indexNuevo = posicionalfabeto + N[indexN];
            }

            resultado.append(alfabeto[indexNuevo]);

        }
        return resultado.toString().toUpperCase();
    }

    private String desencriptar(String fraseEncriptada, int[] N){
        fraseEncriptada = fraseEncriptada.toLowerCase();

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < fraseEncriptada.length(); i++) {
            String aux = String.valueOf(fraseEncriptada.charAt(i));

            int posicionalfabeto = buscarIndice(aux);
            int indexNuevo = 0;
            int indexN = i % N.length;

            if (posicionalfabeto - N[indexN] < 0) {
                indexNuevo = (posicionalfabeto - N[indexN]) + alfabeto.length;
            } else {
                indexNuevo = posicionalfabeto - N[indexN];
            }

            resultado.append(alfabeto[indexNuevo]);
        }
        return resultado.toString().toUpperCase();
    }
}
