package com.example.calculadoraCalorias.service;

import com.example.calculadoraCalorias.dto.response.CaloriasDto;
import com.example.calculadoraCalorias.entity.Plato;

import java.util.List;

public interface ICaloriaService {

   List<CaloriasDto> getCalorias(String plato);
}
