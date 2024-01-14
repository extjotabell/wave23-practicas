package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Producto;
import com.example.clasenosql.service.PorductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductosController {
    @Autowired
    private PorductosService service;

    //agregar producto
    @PostMapping("/producto")
    public Producto save(@RequestBody Producto producto){
        return service.save(producto);
    }

}
