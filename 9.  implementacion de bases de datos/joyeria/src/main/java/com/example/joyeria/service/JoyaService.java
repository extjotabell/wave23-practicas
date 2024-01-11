package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDto;
import com.example.joyeria.dto.ListJoyaDto;
import com.example.joyeria.dto.MessageDto;

public interface JoyaService {
    ListJoyaDto getJoyasList();

    MessageDto addJoya(JoyaDto joya);

    ListJoyaDto deleteJoya(Long id);

    JoyaDto updateJoya(JoyaDto joya, Long id);
}
