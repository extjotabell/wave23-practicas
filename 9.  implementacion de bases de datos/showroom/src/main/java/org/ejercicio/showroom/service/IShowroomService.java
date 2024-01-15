package org.ejercicio.showroom.service;

import org.ejercicio.showroom.model.dto.ClothesDto;

import java.util.List;

public interface IShowroomService {
    ClothesDto saveClothes(ClothesDto clothesDto);

    List<ClothesDto> getClothes();

    ClothesDto getClothesCode(String code);

    ClothesDto editClothes(ClothesDto clothesDto, String code);

    void deleteClothes(String code);

    List<ClothesDto> getClothesSize(Integer size);

    List<ClothesDto> getClothesName(String name);
}
