package com.example.showroom.service;

import com.example.showroom.model.dto.ClothDTO;
import com.example.showroom.model.entity.Cloth;
import com.example.showroom.repository.IClothRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService {
    @Autowired
    IClothRepository repository;

    @Override
    public ClothDTO crateCloth(ClothDTO clothDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Cloth cloth = mapper.convertValue(clothDTO, Cloth.class);
        repository.save(cloth);
        return clothDTO;
    }

    @Override
    public List<ClothDTO> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Cloth> cloths = repository.findAll();
        return cloths.stream().map(cloth -> mapper.convertValue(cloth,ClothDTO.class)).toList();
    }

    @Override
    public ClothDTO getByCode(Integer code) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findById(code)
                .map(c -> mapper.convertValue(c, ClothDTO.class))
                .orElseThrow();
    }

    @Override
    public ClothDTO updateByCode(Integer code, ClothDTO clothDTO) {
        Cloth cloth = repository.findById(code).orElseThrow();
        cloth.setName(clothDTO.getName());
        cloth.setType(clothDTO.getType());
        cloth.setBrand(clothDTO.getBrand());
        cloth.setColor(clothDTO.getColor());
        cloth.setSize(clothDTO.getSize());
        cloth.setAmount(clothDTO.getAmount());
        cloth.setPrecioVenta(clothDTO.getPrecioVenta());
        repository.save(cloth);
        return clothDTO;
    }

    @Override
    public void deleteByCode(Integer code) {
        repository.findById(code).ifPresent(c -> repository.delete(c));
    }

    @Override
    public List<ClothDTO> getBySize(Integer size) {
        ObjectMapper mapper = new ObjectMapper();
        List<Cloth> cloths = repository.findBySize(size);
        return cloths.stream().map(c -> mapper.convertValue(c, ClothDTO.class)).toList();
    }

    @Override
    public List<ClothDTO> getByName(String name) {
        ObjectMapper mapper = new ObjectMapper();
        List<Cloth> cloths = repository.findByNameContainsIgnoreCase(name);
        return cloths.stream().map(c -> mapper.convertValue(c,ClothDTO.class)).toList();
    }
}
