package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    public static HouseDTO getRoomsDto (){
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTOS.add(new RoomDTO("cocina",5,2));
        return new HouseDTO("nombre","direccion",roomDTOS);
    }
}
