package com.spring.elasticsearch.controller;

import com.spring.elasticsearch.model.ObraLiteraria;
import com.spring.elasticsearch.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ObraService obraService;

    @PostMapping("/save")
    public ObraLiteraria save(@RequestBody ObraLiteraria obraLiteraria){
        return obraService.save(obraLiteraria);
    }

    @GetMapping("/getAll")
    public List<ObraLiteraria> getAllObraLiterarias(){
        return obraService.getAll();
    }

    //Retornar las obras de un autor dado por el usuario.
    @GetMapping("/find-by-autor/{autor}")
    public List<ObraLiteraria> findByautor(@PathVariable String autor) { return obraService.findByAutor(autor);}

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @GetMapping("find-by-name/{obraName}")
    public List<ObraLiteraria> findByName(@PathVariable String obraName) { return obraService.findByObra(obraName);}

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @GetMapping("find-by-pages/{pages}")
    public List<ObraLiteraria> findByPages(@PathVariable Integer pages) { return obraService.findByPages(pages);}

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    @GetMapping("find-by-year-before/{year}")
    public List<ObraLiteraria> findByYearBefore(@PathVariable Integer year) { return obraService.findByYearBefore(year);}

    @GetMapping("find-by-year-after/{year}")
    public List<ObraLiteraria> findByYearAfter(@PathVariable Integer year) { return obraService.findByYearAfter(year);}

    //Retornar las obras de una misma editorial.
    @GetMapping("find-by-editorial/{editorial}")
    public List<ObraLiteraria> findByEditorial(@PathVariable String editorial) { return obraService.findByEditorial(editorial);}

}
