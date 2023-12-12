package com.codigoMorse.codigoMorse.controller;
import com.codigoMorse.codigoMorse.model.Espanol;
import com.codigoMorse.codigoMorse.model.Morse;
import com.codigoMorse.codigoMorse.service.MorseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse/")
public class Controller {

    @Autowired
    private MorseServicio morseServicio;

    @GetMapping("/morsetoespanol")
    public String morsetoespanol(@RequestBody Morse morse) {
        return morseServicio.convertirAEspanol(morse.getMorse());
    }

    @GetMapping("/espanoltomorse")
    public String convertirtoMorse(@RequestBody Espanol espanol) {
        return morseServicio.convertirAMorse(espanol.getEspanol());
    }
}
