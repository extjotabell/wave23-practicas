package org.ejercicio.joyeria.utils;


import org.ejercicio.joyeria.DTO.JewerlyDTO;
import org.ejercicio.joyeria.model.Jewerly;

public class JewerlyMapper {
    public static JewerlyDTO jewerlyMap(Jewerly jewerly) {
        return new JewerlyDTO(jewerly.getName(), jewerly.getMaterial(), jewerly.getWeight(), jewerly.getParticularity(), jewerly.getHasStone(), jewerly.getSaleOrNot());
    }

    public static Jewerly jewerlyMap(JewerlyDTO jewerly) {
        return new Jewerly(null, jewerly.getName(), jewerly.getMaterial(), jewerly.getWeight(), jewerly.getParticularity(), jewerly.getHasStone(), jewerly.getSaleOrNot());

    }
}
