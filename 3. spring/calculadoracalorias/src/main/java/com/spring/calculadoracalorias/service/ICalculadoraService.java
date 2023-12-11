package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.PlatoDto;

public interface ICalculadoraService {

    PlatoDto informeCalorico(String nombre);
}
