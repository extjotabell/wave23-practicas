package com.example.joyerialasperlas.utils;

import com.example.joyerialasperlas.dto.JewelCreationDTO;
import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.model.Jewel;

public class Mapper {

  public static JewelDTO jewelToJewelDTO(Jewel jewel) {
    return new JewelDTO(jewel.getId(), jewel.getName(), jewel.getMaterial(), jewel.getWeight(),
        jewel.getParticularity(), jewel.isHaveStone(), jewel.isOnSale());
  }

  public static Jewel jewelCreationDTOToJewel(JewelCreationDTO jewel) {
    return new Jewel(jewel.getName(), jewel.getMaterial(), jewel.getWeight(),
        jewel.getParticularity(), jewel.isHaveStone(), jewel.isOnSale());
  }

  public static Jewel jewelDTOToJewel(JewelDTO jewelDTO) {
    //return new Jewel(je)
    return null;
  }
}
