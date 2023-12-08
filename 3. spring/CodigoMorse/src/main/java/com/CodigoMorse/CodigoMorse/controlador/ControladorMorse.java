package com.CodigoMorse.CodigoMorse.controlador;

import com.CodigoMorse.CodigoMorse.modelo.EspanolRespuesta;
import com.CodigoMorse.CodigoMorse.modelo.MorseRespuesta;
import com.CodigoMorse.CodigoMorse.servicio.MorseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/morse")
public class ControladorMorse {

    @Autowired
    private MorseServicio morseServicio;

    @GetMapping("/convertir")
    public String convertir(@RequestBody MorseRespuesta morse) {
        return morseServicio.convertir(morse.getMorse());
    }

    @GetMapping("/invertir")
    public String invertir(@RequestBody EspanolRespuesta espanol) {
        return morseServicio.inverso(espanol.getEspanol());
    }
}
