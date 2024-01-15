package com.meli.showroom.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.showroom.dtos.request.ClothesDTO;
import com.meli.showroom.entities.Clothes;
import com.meli.showroom.repositories.IClothesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {
    private final IClothesRepository clothesRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ClothesService(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public ClothesDTO createClothes(ClothesDTO clothesDTO) {
        Clothes clothes = objectMapper.convertValue(clothesDTO, Clothes.class);
        return objectMapper.convertValue(clothesRepository.save(clothes),
                                         ClothesDTO.class);
    }

    public List<ClothesDTO> getAllClothes(Optional<String> name) {
        List<Clothes> resultRepo = name.isPresent()? clothesRepository.findAllByName(name.get()) : clothesRepository.findAll();
        return resultRepo.stream()
                         .map(clothes -> objectMapper.convertValue(clothes, ClothesDTO.class))
                         .toList();
        }

    public ClothesDTO getClothesByCode(String code) {
        Clothes existingClothes = clothesRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Clothes not found"));
        return objectMapper.convertValue(existingClothes, ClothesDTO.class);
    }

    public ClothesDTO updateClothes(String code,ClothesDTO clothesDTO) {
        getClothesByCode(code);
        Clothes newClothes = objectMapper.convertValue(clothesDTO, Clothes.class);
        return objectMapper.convertValue(clothesRepository.save(newClothes),
                                         ClothesDTO.class);
    }
    @Transactional
    public Boolean deleteClothes(String code) {
        getClothesByCode(code);
        try{
            clothesRepository.deleteByCode(code);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<ClothesDTO> getClothesBySize(String size) {
        return clothesRepository.findBySize(size).stream()
                .map(clothes -> objectMapper.convertValue(clothes, ClothesDTO.class))
                .toList();
    }
}