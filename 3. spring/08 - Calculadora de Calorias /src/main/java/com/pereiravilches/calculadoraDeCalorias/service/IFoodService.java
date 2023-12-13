package com.pereiravilches.calculadoraDeCalorias.service;

import com.pereiravilches.calculadoraDeCalorias.DTO.PlatoDTO;
import com.pereiravilches.calculadoraDeCalorias.DTO.ResponseDTO;

import java.util.List;

public interface IFoodService {

    ResponseDTO calcularCalorias(String plato);

    List<PlatoDTO> findAllPlatos();

    List <ResponseDTO> calcularCaloriasListPlatos(List<String> platos);
}
