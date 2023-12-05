package com.prueba.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerNumerosRomanos {

    @GetMapping("/{numero}")
        public String getNumeroRomano(@PathVariable String numero) {
        Integer numeroEntero = Integer.parseInt(numero);
        return Utils.numeroRomano1(numeroEntero);
    }
}
