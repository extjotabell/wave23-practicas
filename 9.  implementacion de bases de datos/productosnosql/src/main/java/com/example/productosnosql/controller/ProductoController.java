package com.example.productosnosql.controller;

import com.example.productosnosql.entity.Producto;
import com.example.productosnosql.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @PostMapping("")
    public Producto save(@RequestBody Producto producto){
        return productoService.save(producto);
    }
    @GetMapping("/all")
    public List<Producto> getAllProductos(){
        return productoService.getAll();
    }
    @GetMapping("/by-name/{nombre}")
    public List<Producto> findByName(@PathVariable String nombre) { return productoService.findByNames(nombre);}

}
