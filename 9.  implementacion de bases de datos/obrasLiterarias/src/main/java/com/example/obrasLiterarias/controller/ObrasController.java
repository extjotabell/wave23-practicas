package com.example.obrasLiterarias.controller;

import com.example.obrasLiterarias.model.ObraLiteraria;
import com.example.obrasLiterarias.service.ObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObrasController {
    @Autowired
    ObrasService service;

    //Crear obra literaria
    @PostMapping("/obraliteraria")
    public ObraLiteraria save(@RequestBody ObraLiteraria obraLiteraria){
        return service.save(obraLiteraria);
    }

    //Retornar todas las obras literarias
    @GetMapping("/getall")
    public List<ObraLiteraria> getAll(){
        return service.getAll();
    }

    //Retornar las obras de un autor dado por el usuario.
    @GetMapping("/findbyname/{autor}")
    public List<ObraLiteraria> findByAutor(@PathVariable String autor) {
        return service.findByAutor(autor);}

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @GetMapping("/findbytitle/{nombre}")
    public List<ObraLiteraria> findByTitle(@PathVariable String nombre) {
        return service.findByTitle(nombre);}

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @GetMapping("/findbypages/{cantidadPaginas}")
    public List<ObraLiteraria> findByQPages(@PathVariable Integer cantidadPaginas) {
        return service.findByQPages(cantidadPaginas);}

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario
    // (crear 2 endpoints).
    @GetMapping("/findbyyearbefore/{anioPublicacion}")
    public List<ObraLiteraria> findByYearBefore(@PathVariable Integer anioPublicacion) {
        return service.findByYearBefore(anioPublicacion);}

    @GetMapping("/findbyyearafter/{anioPublicacion}")
    public List<ObraLiteraria> findByYearAfter(@PathVariable Integer anioPublicacion) {
        return service.findByYearAfter(anioPublicacion);}

    //Retornar las obras de una misma editorial.
    @GetMapping("/findbyeditorial/{editorial}")
    public List<ObraLiteraria> findByEditorial(@PathVariable String editorial) {
        return service.findByEditorial(editorial);}
}
