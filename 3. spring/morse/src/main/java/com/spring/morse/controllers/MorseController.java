package com.spring.morse.controllers;

import com.spring.morse.entities.MorseHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/descifrar/{morseMensaje}")
    public String descifrarMorse(@PathVariable String morseMensaje) {
        return MorseHelper.getSentenceFromMorseSentence(morseMensaje);
    }

    @GetMapping("/cifrar/{mensaje}")
    public String cifrarMensaje(@PathVariable String mensaje) {
        return MorseHelper.getMorseSentenceFromABCSentence(mensaje);
    }

}
