package com.meli.jewelry.mappers;

import com.meli.jewelry.dtos.JewelDTO;
import com.meli.jewelry.entities.Jewel;

public class JewelMapper {

    private JewelMapper() {}

    public static JewelDTO toDTO(Jewel jewel) {
        return new JewelDTO(
                jewel.getIdentityNumber(),
                jewel.getName(),
                jewel.getMaterial(),
                jewel.getWeight(),
                jewel.getParticularity(),
                jewel.getHasStone(),
                jewel.getAvailable()
        );
    }

    public static Jewel toEntity(JewelDTO jewelDTO) {
        return Jewel.builder()
                     .name(jewelDTO.getName()).material(jewelDTO.getMaterial())
                     .weight(jewelDTO.getWeight()).particularity(jewelDTO.getParticularity())
                     .hasStone(jewelDTO.getHasStone())
                     .available(jewelDTO.getAvailable())
                     .build();
    }
}
