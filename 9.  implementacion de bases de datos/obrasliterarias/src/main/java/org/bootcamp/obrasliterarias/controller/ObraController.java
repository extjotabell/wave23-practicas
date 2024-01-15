package org.bootcamp.obrasliterarias.controller;

import org.bootcamp.obrasliterarias.model.entity.Obra;
import org.bootcamp.obrasliterarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    private IObraService service;

    @PostMapping("/save")
    public Obra save(@RequestBody Obra obra){
        return service.save(obra);
    }

    @GetMapping("/getall")
    public List<Obra> getAll(){
        return service.getAll();
    }

    @GetMapping("/getbyautor/{autor}")
    public List<Obra> getByAutor(@PathVariable String autor){
        return service.findByAutor(autor);
    }

    @GetMapping("/getbytitle/{titulo}")
    public List<Obra> findByTitle(@PathVariable String titulo){
        return service.findByTitle(titulo);
    }

    @GetMapping("/getbypages/{paginas}")
    public List<Obra> findByAmountOfPages(@PathVariable Integer paginas){
        return service.findByAmountOfPages(paginas);
    }

    @GetMapping("/getbyyear-before/{anio}")
    public List<Obra> findByYearBefore(@PathVariable Integer anio){
        return service.findByYearBefore(anio);
    }

    @GetMapping("/getbyyear-after/{anio}")
    public List<Obra> findByYearAfter(@PathVariable Integer anio){
        return service.findByYearAfter(anio);
    }

    @GetMapping("/getbyeditorial/{editorial}")
    public List<Obra> findByEditorial(String editorial){
        return service.findByEditorial(editorial);
    }

}
