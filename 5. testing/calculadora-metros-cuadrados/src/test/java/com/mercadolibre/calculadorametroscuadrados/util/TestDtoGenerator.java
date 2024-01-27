package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestDtoGenerator {
    public static HouseDTO newHouseDto(){
        return new HouseDTO("Casa", "Avenida Cabildo", List.of(new RoomDTO("Habitación Principal", 5, 8), new RoomDTO("Sala chica", 2,2)));
    }

    public static int responseSquaredFeet(){
        return 44;
    }

    public static int responsePrice(){
        return 35200;
    }

    public static RoomDTO responseBiggestRoom(){
        return new RoomDTO("Habitación Principal", 5, 8);
    }
}
