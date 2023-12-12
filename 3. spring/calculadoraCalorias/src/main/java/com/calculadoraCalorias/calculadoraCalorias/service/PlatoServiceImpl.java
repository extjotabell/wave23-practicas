package com.calculadoraCalorias.calculadoraCalorias.service;
import com.calculadoraCalorias.calculadoraCalorias.dto.IngredienteDto;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoDto;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoResponseDto;
import com.calculadoraCalorias.calculadoraCalorias.entity.Ingrediente;
import com.calculadoraCalorias.calculadoraCalorias.entity.Plato;
import com.calculadoraCalorias.calculadoraCalorias.repository.IngedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    IngedienteRepository repository;

    @Override
    public List<IngredienteDto> getAllIngredientes() {
        return repository.getAllIngredientes().stream()
                .map(i -> new IngredienteDto(i.getName(),i.getCalories()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatoResponseDto> getAllPlatos(){
        return repository.getAllPlatos().stream()
                .map(p -> PlatoResponseDto.builder()
                        .name(p.getName())
                        .ingredients(p.getIngredients().stream()
                                .map(ingrediente -> new IngredienteDto(ingrediente.getName(), ingrediente.getCalories()))
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public PlatoResponseDto buscarPlato(String name, int weight) {
        Plato plato = repository.getAllPlatos()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (plato == null) {
            return null;
        }

        List<IngredienteDto> ingredientesdto = new ArrayList<>();
        int totalCalories = 0;

        for (Ingrediente i : plato.getIngredients()) {
            int ingredientWeight = weight;
            int calories = i.getCalories() * (ingredientWeight / 100); // Calorías ajustadas según el peso

            ingredientesdto.add(new IngredienteDto(i.getName(), calories));
        }

        IngredienteDto maxIngredientDTO = ingredientesdto
                .stream()
                .max(Comparator.comparingInt(IngredienteDto::getCalories))
                .orElse(null);

        return new PlatoResponseDto(name, weight, ingredientesdto, maxIngredientDTO);
    }

    @Override
    public List<PlatoResponseDto> buscarListPlatos(List<PlatoDto> entradaPlato) {
        List<PlatoResponseDto> platos = new ArrayList<>();
        entradaPlato.forEach(d -> platos.add(buscarPlato(d.getName(), d.getWeight())));
        return platos;
    }
}
