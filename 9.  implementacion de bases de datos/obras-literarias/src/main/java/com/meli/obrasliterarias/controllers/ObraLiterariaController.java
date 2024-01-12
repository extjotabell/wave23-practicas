package com.meli.obrasliterarias.controllers;

import com.meli.obrasliterarias.dtos.ObraLiterariaDTO;
import com.meli.obrasliterarias.services.ObraLiterariaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraLiterariaController {

    private static ObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(ObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping
    public ObraLiterariaDTO save( @RequestBody ObraLiterariaDTO obraLiterariaDTO) {
        return obraLiterariaService.save(obraLiterariaDTO);
    }

    @GetMapping("/autor/{autor}")
    public List<ObraLiterariaDTO> findByAutor(@PathVariable String autor){
        return obraLiterariaService.findByAutor(autor);
    }
}
