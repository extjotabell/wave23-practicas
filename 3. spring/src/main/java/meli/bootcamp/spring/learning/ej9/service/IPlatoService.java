package meli.bootcamp.spring.learning.ej9.service;

import java.util.List;

import meli.bootcamp.spring.learning.ej9.dto.request.PlatoRequestDto;
import meli.bootcamp.spring.learning.ej9.dto.response.PlatoResponseDto;

public interface IPlatoService {
  public PlatoResponseDto calcular(PlatoRequestDto plato);

  public List<PlatoResponseDto> calcular(List<PlatoRequestDto> platos);
}
