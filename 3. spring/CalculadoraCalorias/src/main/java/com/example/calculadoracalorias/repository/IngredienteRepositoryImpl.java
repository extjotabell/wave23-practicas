package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {
    private List<IngredienteDTO> database;

    public IngredienteRepositoryImpl() {
        database = loadDataBase();
    }

    @Override
    public IngredienteDTO findIngredienteByName(String name) {
        Optional<IngredienteDTO> first = database.stream().filter(ingredientDTO -> ingredientDTO.getName().equals(name)).findFirst();
        IngredienteDTO result = null;
        if (first.isPresent())
            result = first.get();
        return result;
    }

    private List<IngredienteDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }


}
