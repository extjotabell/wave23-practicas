package org.ejercicio.showroom.controller;

import org.ejercicio.showroom.model.dto.ClothesDto;
import org.ejercicio.showroom.service.IShowroomService;
import org.ejercicio.showroom.service.ShowroomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ShowroomController {

    private final IShowroomService service;

    public ShowroomController(ShowroomServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveClothes(@RequestBody ClothesDto clothesDto) {
        return new ResponseEntity<>(service.saveClothes(clothesDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getClothes() {
        return new ResponseEntity<>(service.getClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code:[a-zA-Z][a-zA-Z0-9]*}")
    public ResponseEntity<?> getClothesCode(@PathVariable String code) {
        return new ResponseEntity<>(service.getClothesCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> getClothes(@RequestBody ClothesDto clothesDto,
                                        @PathVariable String code) {
        return new ResponseEntity<>(service.editClothes(clothesDto, code), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothes(@PathVariable String code) {
        service.deleteClothes(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{size:[0-9]+}")
    public ResponseEntity<?> getClothesSize(@PathVariable Integer size) {
        return new ResponseEntity<>(service.getClothesSize(size),HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getClothesName(@RequestParam String name) {
        return new ResponseEntity<>(service.getClothesName(name),HttpStatus.OK);
    }

}
