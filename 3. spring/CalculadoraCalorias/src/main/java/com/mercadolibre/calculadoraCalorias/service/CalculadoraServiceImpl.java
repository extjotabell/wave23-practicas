package com.mercadolibre.calculadoraCalorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoraCalorias.dto.request.RecetaRequestDto;
import com.mercadolibre.calculadoraCalorias.dto.response.CaloriasResponseDto;
import com.mercadolibre.calculadoraCalorias.dto.response.IngredienteResponseDto;
import com.mercadolibre.calculadoraCalorias.dto.response.IngredientesResponseDto;
import com.mercadolibre.calculadoraCalorias.entity.Ingrediente;
import com.mercadolibre.calculadoraCalorias.entity.Receta;
import com.mercadolibre.calculadoraCalorias.repository.RecetaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {

    @Autowired
    RecetaRepositoryImpl recetaRepository;

    @Override
    public CaloriasResponseDto calcularCalorias(RecetaRequestDto receta) throws Exception {
        if (receta == null) {
            throw new Exception("Por favor ingrese una receta para calcular");
        }
        System.out.println("\nCalculando calorias de la receta: " + receta.getNombre());
        List<Ingrediente> ingredientes = buscarIngredientesByReceta(receta.getNombre());
        Integer calorias = 0;

        for (Ingrediente ingrediente : ingredientes) {
            calorias += ingrediente.getCalories();
        }

        return new CaloriasResponseDto(calorias);
    }

    @Override
    public IngredientesResponseDto obtenerIngredientes(RecetaRequestDto receta) throws Exception {
        if (receta == null) {
            throw new Exception("Por favor ingrese una receta para obtener sus ingredientes");
        }
        System.out.println("\nObteniendo ingredientes de la receta: " + receta.getNombre());
        List<Ingrediente> ingredientes = buscarIngredientesByReceta(receta.getNombre());

        ObjectMapper mapper = new ObjectMapper();
        List<IngredienteResponseDto> response = new ArrayList<>();

        for(Ingrediente ingrediente: ingredientes) {
            response.add(mapper.convertValue(ingrediente, IngredienteResponseDto.class));
        }
        return new IngredientesResponseDto(response);
    }

    @Override
    public IngredienteResponseDto mayorCantidadDeCalorias(RecetaRequestDto receta) throws Exception {
        if (receta == null) {
            throw new Exception("Por favor ingrese una receta para calcular");
        }
        List<Ingrediente> ingredientes = buscarIngredientesByReceta(receta.getNombre());

        ObjectMapper mapper = new ObjectMapper();
        Optional<Ingrediente> optional = ingredientes.stream().max(Comparator.comparingInt(Ingrediente::getCalories));
        if (optional.isEmpty()) {
            throw new Exception("No se logró calcular el ingrediente con mayor cantidad de calorías");
        }
        return mapper.convertValue(optional.get(), IngredienteResponseDto.class);
    }

    private List<Ingrediente> buscarIngredientesByReceta(String receta) throws Exception {
        Receta recetaAlmacenada = recetaRepository.buscarReceta(receta);

        if (recetaAlmacenada == null) {
            throw new Exception("No se encontró la receta " + receta);
        }
        return recetaAlmacenada.getIngredientes();
    }
}
