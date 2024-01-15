package com.ejercicio.showroom.service;

import com.ejercicio.showroom.dto.ClothesDTO;
import com.ejercicio.showroom.model.Clothes;
import com.ejercicio.showroom.repository.IClothesRepository;
import com.ejercicio.showroom.service.Interface.IClothesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements IClothesService {
    private IClothesRepository clothesRepository;

    public ClothesServiceImpl(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public ClothesDTO createClothes(ClothesDTO clotheDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Clothes clothes = mapper.convertValue(clotheDTO, Clothes.class);

        return mapper.convertValue(clothesRepository.save(clothes), ClothesDTO.class);
    }

    @Override
    public ClothesDTO updateClothes(ClothesDTO clothe, Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Clothes clothes = mapper.convertValue(clothe, Clothes.class);

        Clothes existClothes = clothesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clothes not found with ID: " + id));

        try {
            mapper.updateValue(existClothes, clothes);
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear DTO a la entidad: " + e.getMessage());
        }

        Clothes updatedClothes = clothesRepository.save(existClothes);

        return mapper.convertValue(updatedClothes, ClothesDTO.class);
    }


    @Override
    public void deleteClothes(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        clothesRepository.deleteById(id);
    }

    @Override
    public ClothesDTO getClothesById(Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clothes not found with ID: " + id));

        return mapper.convertValue(clothes, ClothesDTO.class);
    }

    @Override
    public List<ClothesDTO> getAllClothes() {
        ObjectMapper mapper = new ObjectMapper();

        List<Clothes> clothes = clothesRepository.findAll();

        return clothes.stream()
                .map(clothe -> mapper.convertValue(clothe, ClothesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClothesDTO> getAllClothesBySize(String size) {
        ObjectMapper mapper = new ObjectMapper();

        List<Clothes> clothes = clothesRepository.getAllClothesBySize(size);

        return clothes.stream()
                .map(clothe -> mapper.convertValue(clothe, ClothesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClothesDTO> getAllClothesByName(String name) {
        ObjectMapper mapper = new ObjectMapper();

        List<Clothes> clothes = clothesRepository.getAllClothesByName(name);

        return clothes.stream()
                .map(clothe -> mapper.convertValue(clothe, ClothesDTO.class))
                .collect(Collectors.toList());
    }
}
