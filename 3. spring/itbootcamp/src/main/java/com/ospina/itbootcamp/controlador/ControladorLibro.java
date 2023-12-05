package com.ospina.itbootcamp.controlador;


import com.ospina.itbootcamp.entidad.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class ControladorLibro {

    private final List<Libro> libros = new ArrayList<>();

    @PostMapping("/crear")
    public String crearLibro(@RequestBody Libro libro){
        libros.add(libro);
        return "Libro creado";
    }

    @GetMapping("/listar")
    public List<Libro> listarLibros(){
        return libros;
    }

    @PutMapping("/cambiarNombre/{titulo}")
    public String cambiarNombre(@PathVariable String titulo, @RequestParam String nuevoNombre){
        for (Libro libro: libros) {
            if(libro.getTitulo().equals(titulo)){
                libro.setTitulo(nuevoNombre);
                return "Nombre cambiado a " + nuevoNombre;
            }
        }
        return "Libro no encontrado con el nombre de " + titulo;
    }

}
