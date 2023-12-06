package com.example.practica_codigo_morse.controllers;

import com.example.practica_codigo_morse.dto.CodigoMorseRequest;
import com.example.practica_codigo_morse.services.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {

    private final CodigoMorseService codigoMorseService;

    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @PostMapping("/convertirMorse")
    public String convertirMorse(@RequestBody CodigoMorseRequest request) {
        return codigoMorseService.convertirMorse(request.getMensaje());
    }

    @PostMapping("/crearMorse")
    public String crearMorse(@RequestBody CodigoMorseRequest request) {
        return codigoMorseService.crearMorse(request.getMensaje());
    }

}
