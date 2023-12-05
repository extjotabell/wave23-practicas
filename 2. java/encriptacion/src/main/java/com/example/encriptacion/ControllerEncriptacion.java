package com.example.encriptacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEncriptacion {

    @GetMapping("/codificar")
    public String codificar(@RequestParam String mensaje) {
        return Utils.codificar(mensaje.toUpperCase(), "23") +
                " Codificado con 23\n" +
                Utils.codificar(mensaje.toUpperCase(), "012") +
                " Codificado con 012";
    }
}
