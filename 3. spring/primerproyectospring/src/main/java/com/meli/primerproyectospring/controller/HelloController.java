package com.meli.primerproyectospring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miapi")
public class HelloController {
    @GetMapping("/pathtest/{nombre}")
    public String miEndpointConPath(@PathVariable String nombre){
        return "Hola " + nombre + "!";
    }
    @GetMapping("/bodytest")
    public String miEndpointConBody(@RequestBody String nombre){
        return "Hola " + nombre + "!";
    }
}
