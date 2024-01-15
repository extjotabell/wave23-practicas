package com.meli.showroom.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.showroom.dtos.request.ClothesDTO;
import com.meli.showroom.entities.Clothes;
import com.meli.showroom.repositories.IClothesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClothesService {
    private final IClothesRepository clothesRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ClothesService(IClothesRepository clothesRepository, IClothesRepository Clothes) {
        this.clothesRepository = clothesRepository;
    }

    public ClothesDTO createClothes(ClothesDTO clothesDTO) {
        Clothes clothes = objectMapper.convertValue(clothesDTO, Clothes.class);
        return objectMapper.convertValue(clothesRepository.save(clothes),
                                         ClothesDTO.class);
    }
}
