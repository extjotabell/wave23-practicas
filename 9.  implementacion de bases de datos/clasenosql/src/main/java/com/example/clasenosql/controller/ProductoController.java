package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Producto;
import com.example.clasenosql.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/add")
    public Producto save(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @GetMapping("/get-all")
    public List<Producto> getAllProductos() {
        return productoService.getAll();
    }

    @GetMapping("/find-by-type/{type}")
    public List<Producto> findByType(@PathVariable String type) {
        return productoService.findByType(type);
    }

    @GetMapping("/find-by-price/{price}")
    public List<Producto> findByPriceByRange(@PathVariable Double price) {
        return productoService.findByPriceByRange(price);
    }

    @GetMapping("/find-by-name/{name}")
    public List<Producto> findByNames(@PathVariable String name) {
        return productoService.findByNames(name);
    }


}
