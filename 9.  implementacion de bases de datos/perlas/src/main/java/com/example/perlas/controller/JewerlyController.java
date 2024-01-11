package com.example.perlas.controller;

import com.example.perlas.model.Jewerly;
import com.example.perlas.service.JewerlyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jewerly")
@RestController
public class JewerlyController {

    private final JewerlyServiceImpl service;

    public JewerlyController(JewerlyServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Integer> createJewerly(@RequestBody Jewerly jewerly){
        return ResponseEntity.ok(service.saveJewerly(jewerly));
    }

    @GetMapping("/list")
    public  ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getJewerly());
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Integer id){
        Jewerly jewerly = service.findJewerly(id);
        jewerly.setVenta(false);
        return ResponseEntity.ok(jewerly);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Jewerly> editJewerly (@PathVariable Integer id,
                                @RequestParam ("nombre") String nombre,
                                @RequestParam ("material") String material,
                                @RequestParam ("peso") float peso,
                                @RequestParam ("particularidad") String particularidad,
                                @RequestParam ("posee_piedra") boolean posee_piedra,
                                @RequestParam ("venta") boolean venta){
        Jewerly jewerly = service.findJewerly(id);
        jewerly.setNombre(nombre);
        jewerly.setMaterial(material);
        jewerly.setPeso(peso);
        jewerly.setParticularidad(particularidad);
        jewerly.setPosee_piedra(posee_piedra);
        jewerly.setVenta(venta);
        service.saveJewerly(jewerly);
        return ResponseEntity.ok(jewerly);
    }
}
