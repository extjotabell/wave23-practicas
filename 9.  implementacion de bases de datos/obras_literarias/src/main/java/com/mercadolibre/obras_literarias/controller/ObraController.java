package com.mercadolibre.obras_literarias.controller;

import com.mercadolibre.obras_literarias.entity.Obra;
import com.mercadolibre.obras_literarias.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;


    @PostMapping("/add")
    public Obra save(@RequestBody Obra obra) {
        return obraService.save(obra);
    }

    @GetMapping("/get-all")
    public List<Obra> getAll() {
        return obraService.findAll();
    }

    @GetMapping("/find-by-autor/{name}")
    public List<Obra> findByAutor(@PathVariable String name) {
        return obraService.findByAutor(name);
    }

    @GetMapping("/find-title-contains/{palabra}")
    public List<Obra> findByTitleContainsWord(@PathVariable String palabra) {
        return obraService.findByTitleContainsWord(palabra);
    }

    @GetMapping("/find-by-pages-count/{cantidad}")
    public List<Obra> findByPagesCount(@PathVariable Integer cantidad) {
        return obraService.findByPagesCount(cantidad);
    }

    @GetMapping("/find-by-year/before/{anio}")
    public List<Obra> findByYearBefore(@PathVariable Integer anio) {
        return obraService.findByYearBefore(anio);
    }

    @GetMapping("/find-by-year/after/{anio}")
    public List<Obra> findByYearAfter(@PathVariable Integer anio) {
        return obraService.findByYearAfter(anio);
    }

    @GetMapping("/find-by-editorial/{editorial}")
    public List<Obra> findByEditorial(@PathVariable String editorial) {
        return obraService.findByEditorial(editorial);
    }
}
