package com.pereiravilches.calculadoraDeCalorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pereiravilches.calculadoraDeCalorias.DTO.IngredienteDTO;
import com.pereiravilches.calculadoraDeCalorias.DTO.PlatoDTO;
import com.pereiravilches.calculadoraDeCalorias.DTO.ResponseDTO;
import com.pereiravilches.calculadoraDeCalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    IFoodRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseDTO calcularCalorias(String plato) {
        PlatoDTO platoDTO = findPlatoByName(plato);
        return new ResponseDTO(getCantidadTotalCalorias(platoDTO), platoDTO.getIngredienteList(), findIngredienteMasCalorias(platoDTO));
    }

    @Override
    public List<PlatoDTO> findAllPlatos() {
        return repository.findAllPlatos().stream()
                .map(plato -> mapper.convertValue(plato,PlatoDTO.class))
                .toList();
    }

    @Override
    public List<ResponseDTO> calcularCaloriasListPlatos(List<String> platos) {
        return platos.stream()
                .map(this::calcularCalorias)
                .toList();
    }


    private PlatoDTO findPlatoByName(String plato){
        return mapper.convertValue(repository.findPlatoByName(plato), PlatoDTO.class);
    }

    private IngredienteDTO findIngredienteMasCalorias (PlatoDTO plato){
        return plato.getIngredienteList().stream()
                .max(Comparator.comparingInt(i -> i.getCalories()))
                .map(ingrediente -> new IngredienteDTO(
                        ingrediente.getName(),
                        ingrediente.getCalories()))
                .orElse(null);
    }

    private Integer getCantidadTotalCalorias(PlatoDTO plato){
        return plato.getIngredienteList().stream()
                .mapToInt(ingrediente -> ingrediente.getCalories())
                .sum();
    }
}
