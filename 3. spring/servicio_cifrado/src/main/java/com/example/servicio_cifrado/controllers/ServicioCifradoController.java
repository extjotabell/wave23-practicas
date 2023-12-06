package com.example.servicio_cifrado.controllers;

import com.example.servicio_cifrado.dto.ServicioCifradoRequest;
import com.example.servicio_cifrado.services.ServicioCifradoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cifrar")
public class ServicioCifradoController {

    @PostMapping
    public String cifrar(@RequestBody ServicioCifradoRequest request) {
        String mensaje = request.getMensaje();
        String clave = request.getClave();

        if (mensaje.length() < 1 || mensaje.length() > 10000)
            throw new IllegalArgumentException("El mensaje debe de tener de 1 a 10000 caracteres de longitud");

        if (clave.length() < 2 || clave.length() > 3)
            throw new IllegalArgumentException("La clave debe ser de valor n = 2 o n = 3");

        return ServicioCifradoService.cifrar(mensaje, clave);
    }
}
