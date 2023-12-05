package com.claseSpring.ejemplo.controllers;

import com.claseSpring.ejemplo.entities.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final List<Libro> listaLibros = new ArrayList<>();

    @PostMapping("/agregar")
    public String agregarLibro(@RequestBody Libro libro){
        listaLibros.add(libro);
        return "Libro agregado: "+ libro.getTitulo();
    }

    @GetMapping("/listar")
    public List<Libro> obtenerListaLibros(){
        return listaLibros;
    }

    @PutMapping("/cambiarNombre/{titulo}")
    public String cambiarNombreLibro(@PathVariable String titulo, @RequestParam String nuevoNombre){
        for (Libro libro : listaLibros){
            if(libro.getTitulo().equals(titulo)){
                libro.setTitulo(nuevoNombre);
                return "El nuevo nombre del titulo es: "+ nuevoNombre;
            }
        }
        return "El libro con el nombre "+ titulo + " no fue encontrado";
    }

}
