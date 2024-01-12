package com.example.obrasliterariaselastic.controller;

import com.example.obrasliterariaselastic.entity.Autor;
import com.example.obrasliterariaselastic.entity.Obra;
import com.example.obrasliterariaselastic.service.ObraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final ObraService obraService;

    public Controller(ObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping("/obra")
    public Obra save(@RequestBody Obra obra){
        return obraService.save(obra);
    }

    @GetMapping("/getAll")
    public List<Obra> getAll(){
        return obraService.getAll();
    }

    @GetMapping("/findByAutor/{nombre}")
    public List<Obra> findByAutor(@PathVariable String nombre) {
        return obraService.findByAutor(nombre);
    }

    @GetMapping("/findByTituloContaining/{titulo}")
    public List<Obra> findByTituloContaining(@PathVariable String titulo) {
        return obraService.findByTituloContaining(titulo);
    }

    @GetMapping("/findByPaginasGreaterThan/{paginas}")
    public List<Obra> findByTituloContaining(@PathVariable Integer paginas) {
        return obraService.findByPaginasGreaterThan(paginas);
    }

    @GetMapping("/findByFechaGreaterThan/{fecha}")
    public List<Obra> findByFechaGreaterThan(@PathVariable Integer fecha) {
        return obraService.findByFechaGreaterThan(fecha);
    }

    @GetMapping("/findByFechaLessThan/{fecha}")
    public List<Obra> findByFechaIsLessThan(@PathVariable Integer fecha) {
        return obraService.findByFechaIsLessThan(fecha);
    }
}
