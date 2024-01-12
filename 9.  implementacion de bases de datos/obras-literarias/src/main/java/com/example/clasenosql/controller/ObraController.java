package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Obra;
import com.example.clasenosql.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @GetMapping
    public Iterable<Obra> getAll() { return obraService.getAll(); }
    @PostMapping
    public Obra save(@RequestBody Obra obra) { return obraService.save(obra); }
    @GetMapping("/{autor}")
    public List<Obra> getAllByAutor(@PathVariable String autor) {
        return obraService.getAllByAutor(autor);
    }
}
