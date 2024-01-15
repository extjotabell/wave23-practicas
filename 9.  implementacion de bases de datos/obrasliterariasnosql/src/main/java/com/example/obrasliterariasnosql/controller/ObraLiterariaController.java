package com.example.obrasliterariasnosql.controller;

import com.example.obrasliterariasnosql.entity.ObraLiteraria;
import com.example.obrasliterariasnosql.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {
    @Autowired
    private ObraLiterariaService obraLiterariaService;
    @PostMapping("")
    public ObraLiteraria save(@RequestBody ObraLiteraria obraLiteraria){
        return obraLiterariaService.save(obraLiteraria);
    }
    @GetMapping("/getAll")
    public List<ObraLiteraria> getAllObrasLiterarias(){
        return obraLiterariaService.getAll();
    }

    @GetMapping("/find-by-autor-eq/{autor}")
    public List<ObraLiteraria> getByAutor(@RequestParam String autor){

        return obraLiterariaService.findByAutor(autor);
    }

    @GetMapping("find-by-words-in-title")
    public List<ObraLiteraria> getByWordsInTitle(@RequestBody ArrayList<String> words){
        return obraLiterariaService.getAll();
    }

    @GetMapping("/find-by-num-pages-gt/{number-of-pages}")
    public List<ObraLiteraria> getByNumberOfPagesGT(
            @RequestParam(name = "number-of-pages") Integer numberOfPages
    ) {
        return obraLiterariaService.findByCantidadPaginasGreaterThanEqual(numberOfPages);
    }

    @GetMapping("/find-by-year-publication-date-gt/{anio}")
    public List<ObraLiteraria> getByYearPublicationGT(@RequestParam Integer anio){
        return obraLiterariaService.findByAnioPrimeraPublicacionGreaterThanEqual(anio);
    }

    @GetMapping("/find-by-year-publication-date-lt/{anio}")
    public List<ObraLiteraria> getByYearPublicationLT(@RequestParam Integer anio){
        return obraLiterariaService.findByAnioPrimeraPublicacionLessThanEqual(anio);
    }

    @GetMapping("/find-by-editorial/{editorial}")
    public List<ObraLiteraria> getByEditorial(@RequestParam String editorial){
        return obraLiterariaService.findbyEditorial(editorial);
    }
}
