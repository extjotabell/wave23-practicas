package com.meli.sqlshowroom.util;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.entity.Clothes;
import com.meli.sqlshowroom.entity.Size;

public class ClothesMapper {

    public static Clothes map(ClothesDTO dto, Size size) {
        return new Clothes(dto.getId(),
                dto.getCode(),
                dto.getName(),
                dto.getBrand(),
                dto.getColor(),
                dto.getStock(),
                dto.getSellingPrice(),
                size
        );
    }

    public static ClothesDTO map(Clothes clothes) {
        return new ClothesDTO(
                clothes.getId(),
                clothes.getCode(),
                clothes.getName(),
                clothes.getBrand(),
                clothes.getColor(),
                clothes.getSize().getId(),
                clothes.getStock(),
                clothes.getSellingPrice()
        );
    }
}
