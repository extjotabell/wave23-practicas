package com.example.showroom.util;

import com.example.showroom.dto.ClotheRequestDTO;
import com.example.showroom.dto.ClotheResponseDTO;
import com.example.showroom.model.Clothe;

public class ClotheDTOMapper {
    public static Clothe mapToClothe(ClotheRequestDTO clotheRequestDTO) {
        return new Clothe(clotheRequestDTO.getName(), clotheRequestDTO.getType(),
                clotheRequestDTO.getBrand(), clotheRequestDTO.getColor(), clotheRequestDTO.getSize(),
                clotheRequestDTO.getQuantity(), clotheRequestDTO.getSalePrice());
    }

    public static ClotheResponseDTO mapToClotheResponseDTO(Clothe clothe) {
        return new ClotheResponseDTO(clothe.getId(), clothe.getName(), clothe.getType(),
                clothe.getBrand(), clothe.getColor(), clothe.getSize(),
                clothe.getQuantity(), clothe.getSalePrice());
    }
}
