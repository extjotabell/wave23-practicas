package com.practice.obras.controller;

import com.practice.obras.entity.Obra;
import com.practice.obras.service.ObraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObraController {
    @Autowired
    private ObraServiceImpl obraService;

    @PostMapping("/obras")
    public Obra save(@RequestBody Obra obra){
        return obraService.save(obra);
    }

    @GetMapping("/obras")
    public List<Obra> listObras(){
        return obraService.listObras();
    }

    @GetMapping("/obras/autor/{autor}")
    public List<Obra> listObrasByAutor(@PathVariable String autor){
        return obraService.listObrasByAutor(autor);
    }

    @GetMapping("/obras/nombre/{keywords}")
    public List<Obra> listObrasWithNombreContainKeywords(@PathVariable String keywords){
        return obraService.listObrasWithNombreContainKeywords(keywords);
    }

    @GetMapping("/obras/cantidad-paginas-greater-than/{number}")
    public List<Obra> listObrasWithCantidadPaginasGreaterThan(@PathVariable String number){
        return obraService.listObrasWithCantidadPaginasGreaterThan(number);
    }

    @GetMapping("/obras/anio-publicacion-less-than/{year}")
    public List<Obra> listObrasWithAnioLessThan(@PathVariable String year){
        return obraService.listObrasWithAnioPublicacionLessThan(year);
    }

    @GetMapping("/obras/anio-publicacion-greater-than/{year}")
    public List<Obra> listObrasWithAnioGreaterThan(@PathVariable String year){
        return obraService.listObrasWithAnioPublicacionGreaterThan(year);
    }

    @GetMapping("/obras/editorial/{editorial}")
    public List<Obra> listObrasByEditorial(@PathVariable String editorial){
        return obraService.listObrasByEditorial(editorial);
    }
}