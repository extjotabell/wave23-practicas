package com.example.biblioteca.controllers;

import com.example.biblioteca.models.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private List<Libro> libros = new ArrayList<>();

    @GetMapping
    public List<Libro> listAll() {
        return libros;
    }

    @PostMapping
    public void add(@RequestBody Libro libro) {
        libros.add(libro);
    }

    @PutMapping("/updateTitulo/{target}")
    public void updateTitulo(@PathVariable int target, @RequestParam String titulo) {
        libros.stream().filter(l -> l.getId() == target).findFirst().ifPresent(value -> value.setTitulo(titulo));
    }

    @PutMapping("/updateAutor/{target}")
    public void updateAutor(@PathVariable int target, @RequestParam String autor) {
        libros.stream().filter(l -> l.getId() == target).findFirst().ifPresent(value -> value.setAutor(autor));
    }

    @DeleteMapping("/{target}")
    public void delete(@PathVariable int target) {
        libros.stream().filter(l -> l.getId() == target).findFirst().ifPresent(l -> libros.remove(l));
    }
}
