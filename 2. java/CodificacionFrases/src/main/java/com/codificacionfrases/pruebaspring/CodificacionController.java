package com.codificacionfrases.pruebaspring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodificacionController {

    @PostMapping("/clvae23")
    public String codificarMensajeClvae23(@RequestParam String mensaje){
        return "";
    }

}
