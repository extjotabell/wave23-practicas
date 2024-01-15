package com.meli.sqlshowroom.service;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.dto.ClothesListDTO;

public interface IClothesService {
    ClothesDTO save(ClothesDTO clothes);

    ClothesListDTO findAll();

    ClothesDTO findByCode(Long code);
}
