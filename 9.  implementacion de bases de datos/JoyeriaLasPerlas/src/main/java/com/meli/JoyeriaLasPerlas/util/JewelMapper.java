package com.meli.JoyeriaLasPerlas.util;

import com.meli.JoyeriaLasPerlas.dto.request.JewelRequestDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewelResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewerlyResponseDTO;
import com.meli.JoyeriaLasPerlas.entity.Jewel;

import java.util.List;

public class JewelMapper {

    public static Jewel mapToJewel(JewelRequestDTO jewelRequestDTO){
        Jewel jewel = new Jewel();
        jewel.setName(jewelRequestDTO.getName());
        jewel.setMaterial(jewelRequestDTO.getMaterial());
        jewel.setWeight(jewelRequestDTO.getWeight());
        jewel.setParticularity(jewelRequestDTO.getParticularity());
        jewel.setHasStone(jewelRequestDTO.isHasStone());
        jewel.setSaleOrNot(jewelRequestDTO.isSaleOrNot());
        return jewel;
    }

    public static JewerlyResponseDTO mapToJewerlyResponseDTO(List<Jewel> jewelList){
        return new JewerlyResponseDTO(jewelList.stream().filter(Jewel::isSaleOrNot).map(JewelMapper::mapToJewelResponseDTO).toList());
    }

    public static JewelResponseDTO mapToJewelResponseDTO(Jewel jewel){
        return new JewelResponseDTO(jewel.getName(), jewel.getMaterial(), jewel.getWeight(), jewel.getParticularity(),
                jewel.isHasStone(), jewel.isSaleOrNot());
    }

}
