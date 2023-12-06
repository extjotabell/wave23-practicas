package com.spring.algoritmoCesar.controller;

import org.springframework.web.bind.annotation.*;

import static com.spring.algoritmoCesar.service.CifrarCesarService.*;

@RestController
@RequestMapping("/api/CifradoCesar")
public class CifradoCesarController {

    @GetMapping("/cifrarFrase012")
    public String cifrarFrase012(@RequestBody String frase) {

        return fraseCifrada012(frase);
    }

    @GetMapping("/cifrarFrase23")
    public String cifrarFrase23(@RequestBody String frase) {

        return fraseCifrada23(frase);
    }

    @GetMapping("/cifrarFrase/{clave}")
    public String cifrarFrase(@PathVariable String clave, @RequestBody String frase) {
        return fraseCifrada(clave, frase);
    }

    @GetMapping("/descifrarFrase/{clave}")
    public String descifrarFrase(@PathVariable String clave, @RequestBody String frase) {
        return fraseDescifrada(frase, clave);
    }
}
