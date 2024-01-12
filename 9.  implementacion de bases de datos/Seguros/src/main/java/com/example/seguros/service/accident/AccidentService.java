package com.example.seguros.service.accident;

import com.example.seguros.dto.AccidentRequestDTO;
import com.example.seguros.dto.AccidentResponseDTO;

import java.util.List;

public interface AccidentService {
    void postAccident(AccidentRequestDTO accidentRequestDTO);

    List<AccidentResponseDTO> findAll();
}
