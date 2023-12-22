package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    private final IObtenerDiplomaService service;

    public ObtenerDiplomaController(IObtenerDiplomaService service) {
        this.service = service;
    }

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}
