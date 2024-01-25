package com.bootcampmeli.edad.controller;

import com.bootcampmeli.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Edad")
public class EdadController {
    private EdadService edadService = new EdadService();

    @GetMapping (path = "/{dia}/{mes}/{anio}")
    public Integer Edad(@PathVariable Integer dia,
                        @PathVariable Integer mes,
                        @PathVariable Integer anio){
        return edadService.getEdad(dia, mes, anio);
    }
    @GetMapping (path = "/{dia}/{mes}/{anio}/{nombre}/{apellido}")
    public String Edad(@PathVariable Integer dia,
                        @PathVariable Integer mes,
                        @PathVariable Integer anio,
                        @PathVariable String nombre,
                        @PathVariable String apellido){
        return edadService.getMensajePersonalizado(edadService.getEdad(dia, mes, anio), nombre, apellido);
    }
}
