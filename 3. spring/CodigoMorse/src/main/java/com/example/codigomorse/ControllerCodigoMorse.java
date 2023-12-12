package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCodigoMorse {
    @GetMapping("/codificar/{mensaje}")
    public String codificarMorse(@PathVariable String mensaje){
        return CodigoMorse.codificarMorse(mensaje);
    }
    @GetMapping("/decodificar/{mensaje}")
    public String decodificarMorse(@PathVariable String mensaje){
        return CodigoMorse.decodificarMorse(mensaje);
    }
}
