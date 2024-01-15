package com.ejercicio.showroom.service.Interface;


import com.ejercicio.showroom.dto.ClothesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IClothesService {
    ClothesDTO createClothes(ClothesDTO clothe);
    ClothesDTO updateClothes(ClothesDTO clothe, Long id);
    void deleteClothes(Long id);
    ClothesDTO getClothesById(Long id);
    List<ClothesDTO> getAllClothes();
    List<ClothesDTO> getAllClothesBySize(String size);
    List<ClothesDTO> getAllClothesByName(String name);
}
