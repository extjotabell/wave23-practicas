package com.example.elastic.controller;

import com.example.elastic.entity.Producto;
import com.example.elastic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Productocontroller {

    @Autowired
    ProductService service;

    @PostMapping("/producto")
    public String save(@RequestBody Producto producto){

        return service.save(producto);
    }

    @GetMapping("/productos")
    public List<Producto> getAll(){
        return service.getAll();
    }

    @PostMapping("/producto/{id}/update")
    public Producto update(@PathVariable String id, @RequestBody Producto producto){
        return service.update(id, producto);
    }


}
