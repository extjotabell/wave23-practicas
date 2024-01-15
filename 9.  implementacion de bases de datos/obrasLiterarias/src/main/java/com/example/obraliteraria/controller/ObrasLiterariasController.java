package com.example.obraliteraria.controller;

import com.example.obraliteraria.entity.ObraLiteraria;
import com.example.obraliteraria.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObrasLiterariasController {
    @Autowired
    private ObraLiterariaService service;

    @PostMapping("/obra-literaria/create")
    public ObraLiteraria save(@RequestBody ObraLiteraria obraLiteraria){
        return service.save(obraLiteraria);
    }

    /* Retornar las obras de un autor dado por el usuario. */
    @GetMapping("/obra-literaria/{autor}")
    public List<ObraLiteraria> findByAutorNombre(@PathVariable String autor){
        return service.findByAutorNombre(autor);
    }

    /* Retornar las obras que contengan palabras dadas por el usuario en sus títulos */
    @GetMapping("/obra-literaria/title/{title}")
    public List<ObraLiteraria> findByTitle(@PathVariable String title){
        return service.findByNombre(title);
    }

    /* Retornar las obras con más cantidad de páginas que las indicadas por el usuario */
    @GetMapping("/obra-literaria")
    public List<ObraLiteraria> findByTitle(@RequestParam int paginas){
        return service.findByPaginas(paginas);
    }

    /* Retornar las obras que fueron publicadas desde de un año dado por el usuario. */
    @GetMapping("/obra-literaria/publicaciones_desde/{year}")
    public List<ObraLiteraria> findByYearFrom(@PathVariable int year){
        return service.findByYearFrom(year);
    }

    /* Retornar las obras que fueron publicadas antes de un año dado por el usuario. */
    @GetMapping("/obra-literaria/publicaciones_hasta/{year}")
    public List<ObraLiteraria> findByYearUntil(@PathVariable int year){
        return service.findByYearUntil(year);
    }

    /* Retornar las obras de una misma editorial. */
    @GetMapping("/obra-literaria/editorial/{editorial}")
    public List<ObraLiteraria> findByEditorial(@PathVariable String editorial){
        return service.findByEditorial(editorial);
    }
}
