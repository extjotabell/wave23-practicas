package com.meli.sqlshowroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClothesListDTO {
    private List<ClothesDTO> clothes;
}
