package com.ospina.calculadoraCalorias.repositorio.comida;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ospina.calculadoraCalorias.modelo.entidad.Ingrediente;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class RepositorioComidaImpl implements RepositorioComida {

    private static final String FILE_PATH = "/food.json";

    @Override
    public List<Ingrediente> obtenerTodos() {
        try (InputStream inputStream = getClass().getResourceAsStream(FILE_PATH)) {
            return new ObjectMapper().readValue(inputStream, new TypeReference<List<Ingrediente>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file at path: " + FILE_PATH, e);
        }
    }
}
