package com.example.Showroom.controller;

import com.example.Showroom.model.dto.request.NewPrendaDto;
import com.example.Showroom.model.dto.response.BaseResponseDto;
import com.example.Showroom.model.entity.Prenda;
import com.example.Showroom.service.ShowroomService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ShowroomController {

    private final ShowroomService service;

    public ShowroomController(ShowroomService service) {
        this.service = service;
    }


    @PostMapping("/api/clothes")
    public ResponseEntity<BaseResponseDto> savePrenda (@RequestBody NewPrendaDto prenda) {
        return ResponseEntity.ok(this.service.savePrenda(prenda));
    }

    @GetMapping("/api/clothes")
    public List<Prenda> getPrendas() {
        return this.service.getAllPrendas();
    }

    @GetMapping("/api/clothes/get/{code}")
    public Prenda getPrenda(@PathVariable Long code) {
        return this.service.getPrenda(code);
    }

    @PutMapping ("/api/clothes/{code}")
    public ResponseEntity<Prenda> editPrenda (@PathVariable Long code,
                                          @RequestBody Prenda prenda) {

        return ResponseEntity.ok(this.service.editPrenda(code, prenda));
    }

    @DeleteMapping("/api/clothes/{code}")
    public ResponseEntity<BaseResponseDto> removePrenda (@PathVariable Long code) {

        return ResponseEntity.ok(this.service.removePrenda(code));
    }

    @GetMapping("/api/clothes/{size}")
    public List<Prenda> getPrendaTalle(@PathVariable String size) {
        return this.service.getPrendaTalle(size);
    }

    @GetMapping("/api/clothes2")
    public List<Prenda> getPrendaNombre(@RequestParam String nombre) {
        return this.service.getPrendaNombre(nombre);
    }
}
