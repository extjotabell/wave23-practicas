package com.meli.joyeria.utils;

import com.meli.joyeria.dto.request.JoyaCreationDTO;
import com.meli.joyeria.dto.response.JoyaCompletaDTO;
import com.meli.joyeria.model.Joya;

public class Mapper {
    public static Joya mapJoyaCreationDtoToJoya(JoyaCreationDTO joyaDto){
        return new Joya(
                null,
                joyaDto.getNombre(),
                joyaDto.getMaterial(),
                joyaDto.getPeso(),
                joyaDto.getParticularidad(),
                joyaDto.getPoseePiedra(),
                joyaDto.getVentaONo()
        );
    }

    public static JoyaCompletaDTO mapJoyaToJoyaCompletaDto(Joya joya){
        return new JoyaCompletaDTO(
                joya.getId(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPoseePiedra(),
                joya.getVentaONo()
        );
    }
}
