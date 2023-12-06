package com.spring.codigomorse.controller;

import com.spring.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/CodigoMorse")
public class CodigoMorseController {

    @GetMapping("/descifrar/{codigo}")
    public String descifrar(@PathVariable String codigo) {

        return new CodigoMorseService().decifrar(codigo);
    }

    @GetMapping("/cifrar/{frase}")
    public String cifrar(@PathVariable String frase) {

        return new CodigoMorseService().cifrar(frase);
    }
}
