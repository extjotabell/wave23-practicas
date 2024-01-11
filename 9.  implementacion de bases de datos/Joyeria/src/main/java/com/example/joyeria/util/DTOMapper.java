package com.example.joyeria.util;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaResponseDTO;
import com.example.joyeria.model.Joya;

public class DTOMapper {
    public static Joya mapToJoya(JoyaRequestDTO joyaRequestDTO) {
        return new Joya(joyaRequestDTO.getNombre(), joyaRequestDTO.getMaterial(), joyaRequestDTO.getPeso(),
                joyaRequestDTO.getParticularidad(), joyaRequestDTO.isPoseePiedra(), joyaRequestDTO.isVendida());
    }

    public static JoyaResponseDTO mapToJoyaResponseDTO(Joya joya) {
        return new JoyaResponseDTO(joya.getId(), joya.getNombre(), joya.getMaterial(), joya.getPeso(),
                joya.getParticularidad(), joya.isPoseePiedra(), joya.isVendida());
    }
}
