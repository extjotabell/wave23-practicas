package com.spring.encriptacion.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CifradoController {
    private static List<String> abecedario = new ArrayList<>(List.of("A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"));

    @GetMapping("/api/{clave}/{mensaje}")
    public String encriptarMensaje(@PathVariable String clave,  @PathVariable String mensaje) {
        List<Integer> desplazamientosPorDigito = clave
                .chars()
                .mapToObj(Character::getNumericValue)
                .toList();

        int cantidadDigitos = desplazamientosPorDigito.size(); // N

        List<String> mensajeLetras = Arrays
                .stream(mensaje
                        .replaceAll(" ", "")
                        .toUpperCase()
                        .split(""))
                .toList();

        StringBuilder mensajeEncriptado= new StringBuilder();
        int pos = 0;
        for(String letra: mensajeLetras){
            int indxDesplazamiento = pos % cantidadDigitos;
            int desplazamiento = desplazamientosPorDigito.get(indxDesplazamiento);

            int indxABC = abecedario.indexOf(letra);
            int indxDesplazadaABC = (indxABC + desplazamiento) % abecedario.size();

            String letraDesplazada = abecedario.get(indxDesplazadaABC);

            mensajeEncriptado.append(letraDesplazada);
            pos++;
        }
        return mensajeEncriptado.toString();
    }
}
