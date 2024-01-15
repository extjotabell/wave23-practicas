package com.example.showroom.service;

import com.example.showroom.model.dto.ClothDTO;

import java.util.List;

public interface IClothService {
    ClothDTO crateCloth(ClothDTO clothDTO);
    List<ClothDTO>getAll();
    ClothDTO getByCode(Integer code);
    ClothDTO updateByCode(Integer code, ClothDTO clothDTO);
    void deleteByCode(Integer code);
    List<ClothDTO>getBySize(Integer size);
    List<ClothDTO>getByName(String name);
}
