package com.meli.obrasliterarias.controllers;

import com.meli.obrasliterarias.dtos.ObraLiterariaDTO;
import com.meli.obrasliterarias.services.ObraLiterariaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
