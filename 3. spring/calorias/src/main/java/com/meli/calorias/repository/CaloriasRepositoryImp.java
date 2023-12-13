package com.meli.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calorias.entity.Ingrediente;
import com.meli.calorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CaloriasRepositoryImp implements CaloriasRepository {

    private List<Ingrediente> ingredientes;
    private List<Plato> platos;

    public CaloriasRepositoryImp() {
        this.ingredientes = loadIngredientes();
        this.platos = new ArrayList<>(List.of(
            new Plato("Plato 1", List.of(
                ingredientes.get(0),
                ingredientes.get(1),
                ingredientes.get(2)
            )),
            new Plato("Plato 2", List.of(
                ingredientes.get(3),
                ingredientes.get(4),
                ingredientes.get(5)
            )),
            new Plato("Plato 3", List.of(
                ingredientes.get(6),
                ingredientes.get(7),
                ingredientes.get(8)
            ))
        ));
    }

    @Override
    public List<Ingrediente> loadIngredientes() {
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};

        List<Ingrediente> list = null;

        try {
            list = objectMapper.readValue(jsonFile, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return list;
    }

    @Override
    public Plato getPlato(String nombre) {
        return platos.stream()
            .filter(plato -> plato.getName().equals(nombre))
            .findFirst()
            .orElse(null);
    }
}
