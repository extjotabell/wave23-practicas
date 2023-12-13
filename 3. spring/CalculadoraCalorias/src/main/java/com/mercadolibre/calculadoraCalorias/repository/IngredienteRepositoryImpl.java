package com.mercadolibre.calculadoraCalorias.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoraCalorias.entity.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() {
        loadData();
    }

    private void loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeReference = new TypeReference<>() {};
        List<Ingrediente> list = null;
        try {
            list = mapper.readValue(file, typeReference);
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ingredientes = list;
    }

    @Override
    public Ingrediente buscarIngrediente(String nombre) {
        Optional<Ingrediente> optional = ingredientes.stream().filter(
                i -> i.getName().equalsIgnoreCase(nombre)
        ).findFirst();

        if (optional.isPresent()) {
            return optional.get();
        } else {
            System.out.println("No se encontró el ingrediente: " + nombre);
            return null;
        }

    }

    @Override
    public List<Ingrediente> buscarTodos() {
        return ingredientes;
    }


}
