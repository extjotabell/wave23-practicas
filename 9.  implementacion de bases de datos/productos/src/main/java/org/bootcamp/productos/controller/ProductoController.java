package org.bootcamp.productos.controller;

import org.bootcamp.productos.model.entity.Producto;
import org.bootcamp.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService service;

    @GetMapping("/getall")
    public List<Producto> getAll(){
        return service.getAll();
    }

    @PostMapping("/save")
    public Producto save(@RequestBody Producto producto){
        return service.save(producto);
    }

    @PutMapping("/update")
    public Producto update(@RequestBody Producto producto){
        return service.update(producto);
    }

}
