package com.meli.calorias.service;

import com.meli.calorias.dto.IngredienteDto;
import com.meli.calorias.dto.PlatoDto;
import com.meli.calorias.entity.Ingrediente;
import com.meli.calorias.entity.Plato;
import com.meli.calorias.repository.CaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaloriasServiceImp implements CaloriasService {

    @Autowired
    private CaloriasRepository caloriasRepository;

    @Override
    public PlatoDto getPlato(String nombre, double peso) {
        Plato plato = caloriasRepository.getPlato(nombre);

        if (plato == null) {
            return null;
        }

        double caloriasTotales = plato.getIngredientes().stream()
            .mapToDouble(Ingrediente::getCalories)
            .sum() * (peso / 100);

        Ingrediente ingredienteMasCalorico = plato.getIngredientes().stream()
            .max((ingrediente1, ingrediente2) -> (int) (ingrediente1.getCalories() - ingrediente2.getCalories()))
            .orElse(null);

        IngredienteDto ingredienteMasCaloricoDto = new IngredienteDto(
            ingredienteMasCalorico.getName(),
            ingredienteMasCalorico.getCalories()
        );

        List<IngredienteDto> ingredientesDto = plato.getIngredientes().stream()
            .map(ingrediente -> new IngredienteDto(
                ingrediente.getName(),
                ingrediente.getCalories()
            ))
            .toList();

        return new PlatoDto(
            plato.getName(),
            ingredientesDto,
            caloriasTotales,
            ingredienteMasCaloricoDto
        );
    }
}
