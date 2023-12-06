package com.claseUno.ejemplo.controllers;

import com.claseUno.ejemplo.entities.Libro;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroController {

    private final List<Libro> libros = new ArrayList<>();

    @PostMapping("/agregar")
    public String agregarLibro(@RequestBody Libro libro) {
        libros.add(libro);
        return "Libro agregado: " + libro.getTitulo();
    }

    @GetMapping("/listar")
    public List<Libro> listarLinros() {
        return this.libros;
    }

    @PutMapping("/modificarNombre/{nombreLibro}")
    public String modificarNombre(@PathVariable String nombreLibro, @RequestParam String nuevoNombre) {
        Libro libro = this.libros.stream()
                .filter(libro1 -> libro1.getTitulo().equals(nombreLibro))
                .findFirst()
                .orElse(null);

        if (libro != null) {
            libro.setTitulo(nuevoNombre);
            return "Se cambió el nombre a: " + libro.getTitulo();
        }
        return "Libro no encontrado con el título: " + nombreLibro;
    }
}

