package com.example.showroom.controller;

import com.example.showroom.model.dto.ClothDTO;
import com.example.showroom.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clothes")
public class ClothController {

    @Autowired
    ClothService service;

    //Crear una nueva prenda
    @PostMapping
    public ResponseEntity<?> crateCloth(@RequestBody ClothDTO clothDto){
        return ResponseEntity.ok(service.crateCloth(clothDto));
    }

    //Devolver todas las prendas
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    //Devolver una prenda en particular
    @GetMapping("/code/{code}")
    public ResponseEntity<?> getByCode(@PathVariable Integer code){
        return ResponseEntity.ok(service.getByCode(code));
    }

    //Actualizar una prenda en particular
    @PutMapping("/{code}")
    public ResponseEntity<?> updateByCode(@PathVariable Integer code, @RequestBody ClothDTO clothDTO){
        return ResponseEntity.ok(service.updateByCode(code,clothDTO));
    }

    //Eliminar una prenda en particular
    @DeleteMapping("/{code}")
    public void deleteByCode(@PathVariable Integer code){
        service.deleteByCode(code);
    }

    //Traer todas las prendas de un determinado talle
    @GetMapping("size/{size}")
    public ResponseEntity<?> getBySize(@PathVariable Integer size){
        return ResponseEntity.ok(service.getBySize(size));
    }

    //Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        return ResponseEntity.ok(service.getByName(name));
    }
}
