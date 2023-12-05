package com.codificaciondemensaje.codificaciondemensaje.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EncriptarController {

    private final List<Character> abecedario = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    @GetMapping("/encriptar23")
    public String codificar23(@RequestBody String mensaje) {
        String mensajeFormateado = mensaje.toUpperCase().replace(" ", "");
        String mensajeEncriptado = "";
        char caracter;
        int posAbecedario, indiceNuevoCaracter;

        // YO HE LOGRADO ENCENDER UNA CERILLA
        // AR JH NRIUCGQ HPFGQFHT XPD EHTLNOC
        for (int i = 1; i <= mensajeFormateado.length(); i++) {
            caracter = mensajeFormateado.charAt(i - 1);
            posAbecedario = this.abecedario.indexOf(caracter);

            if (i % 2 == 0) {
                indiceNuevoCaracter = (posAbecedario + 3) % this.abecedario.size();
                mensajeEncriptado = mensajeEncriptado.concat(this.abecedario.get(indiceNuevoCaracter).toString());
            }
            else {
                indiceNuevoCaracter = (posAbecedario + 2) % this.abecedario.size();
                mensajeEncriptado = mensajeEncriptado.concat(this.abecedario.get(indiceNuevoCaracter).toString());
            }

        }

        return "El mensaje: " + mensaje + "\n" + "Luego del encriptado es: " + mensajeEncriptado;

    }

    @GetMapping("/encriptar012")
    public String codificar012(@RequestBody String mensaje) {
        String mensajeFormateado = mensaje.toUpperCase().replace(" ", "");
        String mensajeEncriptado = "";
        Character caracter;
        int posAbecedario, indiceNuevoCaracter, contador = 1;

        // YOHELOGRADOENCENDERUNACERILLA
        // YPJEMQGSCDPGNDGNEGRVPADGRJNLB
        for (int i = 1; i <= mensajeFormateado.length(); i++) {
            caracter = mensajeFormateado.charAt(i - 1);
            posAbecedario = this.abecedario.indexOf(caracter);

            switch (contador) {
                case 1 -> {
                    mensajeEncriptado = mensajeEncriptado.concat(caracter.toString());
                    contador++;
                }
                case 2 -> {
                    indiceNuevoCaracter = (posAbecedario + 1) % this.abecedario.size();
                    mensajeEncriptado = mensajeEncriptado.concat(this.abecedario.get(indiceNuevoCaracter).toString());
                    contador++;
                }
                case 3 -> {
                    indiceNuevoCaracter = (posAbecedario + 2) % this.abecedario.size();
                    mensajeEncriptado = mensajeEncriptado.concat(this.abecedario.get(indiceNuevoCaracter).toString());
                    contador = 1;
                }
            }
        }

        return "El mensaje: " + mensaje + "\n" + "Luego del encriptado es: " + mensajeEncriptado;

    }
}
