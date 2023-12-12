package meli.bootcamp.spring.learning.ej9.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej9.dto.request.PlatoRequestDto;
import meli.bootcamp.spring.learning.ej9.dto.response.IngredienteResponseDto;
import meli.bootcamp.spring.learning.ej9.dto.response.PlatoResponseDto;
import meli.bootcamp.spring.learning.ej9.entity.Ingrediente;
import meli.bootcamp.spring.learning.ej9.entity.Plato;
import meli.bootcamp.spring.learning.ej9.repository.impl.PlatoRepository;
import meli.bootcamp.spring.learning.ej9.service.IPlatoService;

@Service
public class PlatoService implements IPlatoService {

  @Autowired
  private PlatoRepository repository;

  @Override
  public PlatoResponseDto calcular(PlatoRequestDto plato) {
    Optional<Plato> posiblePlato = repository.obtenerPorNombre(plato.getNombre());
    if (!posiblePlato.isPresent()) {
      return null;
    }
    Plato platoEncontrado = posiblePlato.get();
    Integer totalCalorias = platoEncontrado.getIngredientes().stream()
        .mapToInt(i -> i.getCalories() * plato.getGramos()).sum();

    List<IngredienteResponseDto> ingredientes = new ArrayList<IngredienteResponseDto>();
    platoEncontrado.getIngredientes()
        .forEach(i -> ingredientes.add(new IngredienteResponseDto(i.getName(), i.getCalories())));

    String ingredienteMaxCalorias = platoEncontrado.getIngredientes().stream()
        .max(Comparator.comparing(Ingrediente::getCalories)).get().getName();

    return new PlatoResponseDto(totalCalorias, ingredientes, ingredienteMaxCalorias);
  }

  @Override
  public List<PlatoResponseDto> calcular(List<PlatoRequestDto> platos) {
    return platos.stream().map(this::calcular).toList();
  }

}
