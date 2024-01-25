package com.bootcampmeli.morse.controller;

import com.bootcampmeli.morse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/CodigoMorse")
public class CodigoMorseController {
    CodigoMorseService servicioMorse = new CodigoMorseService();

    @PostMapping("/decifrarFrase")
    public String descifrarFrase(@RequestBody String frase){
        return servicioMorse.descifrarFrase(frase);
    }

    @PostMapping("/cifrarFrase")
    public String cifrarFrase(@RequestBody String frase){
        return servicioMorse.cifrarFrase(frase);
    }
}
