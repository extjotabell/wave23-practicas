package com.spring.morse.controllers;

import com.spring.morse.entities.MorseHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/descifrar/{morseMensaje}")
    public String descifrarMorse(@RequestParam String morseMensaje) {
        return MorseHelper.getSentenceFromMorseSentence(morseMensaje);
    }

    @GetMapping("/cifrar/")
    public String cifrarMensaje(@RequestParam String mensaje) {
        return MorseHelper.getMorseSentenceFromABCSentence(mensaje);
    }

}
