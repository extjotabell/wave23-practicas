package com.example.practica_codigo_morse.controllers;

import com.example.practica_codigo_morse.dto.CodigoMorseRequest;
import com.example.practica_codigo_morse.services.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    private final CodigoMorseService codigoMorseService;

    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @PostMapping("/morseATexto")
    public String morseATexto(@RequestBody CodigoMorseRequest request) {
        return codigoMorseService.morseATexto(request.getMensaje());
    }

    @PostMapping("/textoAMorse")
    public String textoAMorse(@RequestBody CodigoMorseRequest request) {
        return codigoMorseService.textoAMorse(request.getMensaje());
    }

}
