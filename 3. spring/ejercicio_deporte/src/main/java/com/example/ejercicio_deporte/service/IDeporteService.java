package com.example.ejercicio_deporte.service;

import com.example.ejercicio_deporte.dto.DeporteDto;

import java.util.List;

public interface IDeporteService {
    List<DeporteDto> getAllDeporte();

    List<DeporteDto> getDeporte(String variable);
}
