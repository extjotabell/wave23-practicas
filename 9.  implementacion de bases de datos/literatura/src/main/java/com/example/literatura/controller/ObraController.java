package com.example.literatura.controller;

import com.example.literatura.entity.Obra;
import com.example.literatura.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObraController {
    @Autowired
    ObraService service;

    @PostMapping("/obras")
    public Obra save(@RequestBody Obra obra){
        return service.save(obra);
    }

}
