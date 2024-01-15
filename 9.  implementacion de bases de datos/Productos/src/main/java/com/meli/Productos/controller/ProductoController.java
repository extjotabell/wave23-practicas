package com.meli.Productos.controller;

import com.meli.Productos.dto.ProductoDto;
import com.meli.Productos.dto.MessageDto;
import com.meli.Productos.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<ProductoDto> create(@RequestBody ProductoDto productoDto) {
        ProductoDto empleado = service.save(productoDto);
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<ProductoDto> empleados = service.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        ProductoDto empleado = service.findById(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        MessageDto message = new MessageDto("Empleado eliminado");
        return ResponseEntity.ok(message);
    }

}
