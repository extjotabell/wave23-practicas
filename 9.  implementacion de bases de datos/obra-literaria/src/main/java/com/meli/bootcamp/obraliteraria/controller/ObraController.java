package com.meli.bootcamp.obraliteraria.controller;

import co.elastic.clients.elasticsearch.nodes.Http;
import com.meli.bootcamp.obraliteraria.dto.ObraDto;
import com.meli.bootcamp.obraliteraria.entity.Obra;
import com.meli.bootcamp.obraliteraria.service.ObraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {
    @Autowired
    private ObraServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<ObraDto> save(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(service.save(obraDto),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ObraDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //Retornar las obras de un autor dado por el usuario.
    @GetMapping("/findByAutor")
    public ResponseEntity<List<ObraDto>> findByAutor(@RequestParam String nombreAutor){
        return new ResponseEntity<>(service.findByAutor(nombreAutor), HttpStatus.OK);
    }
    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @GetMapping("/filterByTitle/{palabras}")
    public ResponseEntity<List<ObraDto>> findByTitle(@PathVariable String palabras){
        return new ResponseEntity<>(service.findByTitle(palabras),HttpStatus.OK);
    }
    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @GetMapping("/findByPages/{pages}")
    public ResponseEntity<List<ObraDto>> findByPages(@PathVariable int pages){
        return new ResponseEntity<>(service.findByCantidadPaginasGreaterThan(pages),HttpStatus.OK);
    }

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    @GetMapping("/findByYearLessThan/{year}")
    public ResponseEntity<List<ObraDto>> findByFechaPublicacionLessThan(@PathVariable int year){
        return new ResponseEntity<>(service.findByFechaPublicacionLessThan(year),HttpStatus.OK);
    }
    @GetMapping("/findByYearGreaterThan/{year}")
    public ResponseEntity<List<ObraDto>> findByFechaPublicacionGreaterThan(@PathVariable int year){
        return new ResponseEntity<>(service.findByFechaPublicacionGreaterThan(year),HttpStatus.OK);
    }
    //Retornar las obras de una misma editorial.
    @GetMapping("/findByEditorial/{editorial}")
    public ResponseEntity<List<ObraDto>> findByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(service.findByEditorial(editorial),HttpStatus.OK);
    }

}
