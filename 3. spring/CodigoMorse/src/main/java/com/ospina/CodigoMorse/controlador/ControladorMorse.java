package com.ospina.CodigoMorse.controlador;

import com.ospina.CodigoMorse.modelo.MorseRespuesta;
import com.ospina.CodigoMorse.servicio.MorseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/morse")
public class ControladorMorse {

    @Autowired
    private MorseServicio morseServicio;

    @GetMapping("/convertir")
    public String convertir(@RequestBody MorseRespuesta morse) {
        return morseServicio.convertir(morse.getMorse());
    }
}
