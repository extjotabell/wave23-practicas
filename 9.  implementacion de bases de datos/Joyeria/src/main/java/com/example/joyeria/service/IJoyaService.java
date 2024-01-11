package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {
    Long nuevaJoya(JoyaRequestDTO joyaRequestDTO);

    List<JoyaResponseDTO> joyas();

    void eliminarJoya(Long id);

    JoyaResponseDTO actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO);
}
