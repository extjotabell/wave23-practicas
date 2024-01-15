package com.example.showroom.service;


import com.example.showroom.model.Clothes;
import com.example.showroom.repository.IClothesRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ClothesService {

  private final IClothesRepository clothesRepository;

  public ClothesService(IClothesRepository clothesRepository) {
    this.clothesRepository = clothesRepository;
  }

  public String createClothes(@RequestBody Clothes clothes) {
    return clothesRepository.save(clothes).getCode();
  }

  public List<Clothes> getClothes() {
    return StreamSupport.stream(clothesRepository.findAll().spliterator(),false).collect(Collectors.toList());
  }

  public Clothes getClothesByCode(String code) {
    return clothesRepository.findById(code).orElse(null);
  }

  public Clothes updateClothes(String code, @RequestBody Clothes clothes) {
    clothes.setCode(code);
    clothesRepository.save(clothes);
    return clothes;
  }

  public String deleteClothes(String code) {
    clothesRepository.deleteById(code);
    return "Se ha eliminado la prenda";
  }

  public List<Clothes> getClothesBySize(@PathVariable int size) {
    return clothesRepository.findBySize(size);
  }

  public List<Clothes> getClothesByNameContaining(@RequestParam String name) {
    return clothesRepository.findByNameContaining(name);
  }
}
