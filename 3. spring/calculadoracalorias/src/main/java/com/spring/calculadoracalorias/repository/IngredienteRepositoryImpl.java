package com.spring.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
@Data
public class IngredienteRepositoryImpl implements IIngredienteRepository {

    private List<Ingrediente> ingredientes;

    private void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/java/com/spring/calculadoracalorias/resource/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IngredienteRepositoryImpl() {
        loadDataBase();
    }

    @Override
    public Ingrediente buscarIngrediente(String nombre) {
        return ingredientes.stream().filter(i -> i.getNombre().toUpperCase().equals(nombre.toUpperCase())).findFirst().get();
    }
}
