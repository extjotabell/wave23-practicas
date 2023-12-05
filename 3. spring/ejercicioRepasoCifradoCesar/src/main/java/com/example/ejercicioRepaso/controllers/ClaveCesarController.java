package com.example.ejercicioRepaso.controllers;

import com.example.ejercicioRepaso.entities.Encript;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cesar")
public class ClaveCesarController {

    @PostMapping("/encriptar")
    public String encriptar(@RequestBody Encript encript)  {
        return obtenerMensajeEnciptado(encript.getPalabra(), encript.getClave());
    }

    private String obtenerMensajeEnciptado(String palabra, String clave) {

        String claveUpper = clave.toUpperCase();

        int n = claveUpper.length();

        String cifrado = "";
        int pos = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != ' ') {
                int desplazamiento = clave.charAt(pos) - '0';
                int numeroChar = (int) palabra.charAt(i);
                char c = '-';
                if (numeroChar + desplazamiento > 90) {
                    int resto = (numeroChar + desplazamiento) % 90;
                    c = (char) (resto + 64);
                } else {
                    c = (char) ((int) palabra.charAt(i) + desplazamiento);
                }
                cifrado += c;
                pos = (pos + 1) % n;
            }
        }
        return cifrado;
    }
}


