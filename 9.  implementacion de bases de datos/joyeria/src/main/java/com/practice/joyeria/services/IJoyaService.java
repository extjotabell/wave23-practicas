package com.practice.joyeria.services;

import com.practice.joyeria.dtos.JoyaDTO;
import com.practice.joyeria.dtos.JoyaResponseDTO;
import com.practice.joyeria.dtos.MessageDTO;

import java.util.List;

public interface IJoyaService {

    MessageDTO saveJewerly(JoyaDTO joyaDTO);

    List<JoyaResponseDTO> getAllJewerly();

    MessageDTO logicDeleteJewerly(Long id);

    JoyaResponseDTO getJewerly(Long id);

    JoyaResponseDTO updateJewerly(Long id, JoyaDTO joyaDTO);
}
