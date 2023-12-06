package com.ejemplo.ejemploSpringLibros.controllers;

import com.ejemplo.ejemploSpringLibros.entities.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    List<Libro> libros = new ArrayList<>();

    @PostMapping
    public String agregarLibro(@RequestBody Libro libro){
        libros.add(libro);
        return "OK";
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return this.libros;
    }

    @DeleteMapping("/{titulo}")
    public String eliminarLibro(@PathVariable String titulo){
        List<Libro> encontrados = this.libros.stream()
                .filter(libro -> libro.getTitulo().equals(titulo))
                .toList();

        for(Libro libro : encontrados){
            this.libros.remove(libro);
        }

        return "OK";
    }
    
    @PatchMapping("/{titulo}")
    public String sustituirLibro(@PathVariable String titulo, @RequestBody Libro libroNuevo){
        List<Libro> encontrados = this.libros.stream()
                .filter(libro -> libro.getTitulo().equals(titulo))
                .toList();

        for(Libro libro : encontrados){
            libro.setAutor(libroNuevo.getAutor());
            libro.setTitulo(libroNuevo.getTitulo());
        }

        return "OK";
    }

    @PutMapping("/{titulo}")
    public String modificarLibro(@PathVariable String titulo, @RequestBody Libro libroNuevo){
        List<Libro> encontrados = this.libros.stream()
                .filter(libro -> libro.getTitulo().equals(titulo))
                .toList();

        for(Libro libro : encontrados){
            if(libroNuevo.getTitulo() != null){
                libro.setTitulo(libroNuevo.getTitulo());
            }

            if(libroNuevo.getAutor() != null){
                libro.setAutor(libroNuevo.getAutor());
            }
        }

        return "OK";
    }

}
