package com.meli.calorias.service;

import com.meli.calorias.dto.PlatoDto;

public interface CaloriasService {
    PlatoDto getPlato(String nombre, double peso);
}
