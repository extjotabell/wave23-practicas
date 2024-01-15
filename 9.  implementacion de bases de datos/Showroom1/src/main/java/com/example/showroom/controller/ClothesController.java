package com.example.showroom.controller;

import com.example.showroom.model.Clothes;
import com.example.showroom.service.ClothesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

  private final ClothesService clothesService;

  public ClothesController(ClothesService clothesService) {
    this.clothesService = clothesService;
  }

  @PostMapping
  public ResponseEntity<?> createClothes(@RequestBody Clothes clothes) {
    return ResponseEntity.ok(clothesService.createClothes(clothes));
  }

  @GetMapping("/{code}")
  public ResponseEntity<?> getClothesByCode(@PathVariable String code) {
    return ResponseEntity.ok(clothesService.getClothesByCode(code));

  }

  @PutMapping("/{code}")
  public ResponseEntity<?> updateClothes(@PathVariable String code, @RequestBody Clothes clothes) {
    return ResponseEntity.ok(clothesService.updateClothes(code, clothes));
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<?> deleteClothes(@PathVariable String code) {
    return ResponseEntity.ok(clothesService.deleteClothes(code));

  }

  @GetMapping("/size/{size}")
  public ResponseEntity<?> getClothesBySize(@PathVariable int size) {
    return ResponseEntity.ok(clothesService.getClothesBySize(size));

  }

  @GetMapping
  public ResponseEntity<?> getClothes(@RequestParam(required = false) String name) {
    if(name==null){
      return ResponseEntity.ok(clothesService.getClothes());
    }
    return ResponseEntity.ok(clothesService.getClothesByNameContaining(name));

  }
}
