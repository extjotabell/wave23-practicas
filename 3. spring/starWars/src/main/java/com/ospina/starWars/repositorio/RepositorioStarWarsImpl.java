package com.ospina.starWars.repositorio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ospina.starWars.modelo.entidad.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class RepositorioStarWarsImpl implements RepositorioStarWars {

    private static final String FILE_PATH = "/starwars.json";

    @Override
    public List<Personaje> obtenerTodos() {
        try (InputStream inputStream = getClass().getResourceAsStream(FILE_PATH)) {
            return new ObjectMapper().readValue(inputStream, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file at path: " + FILE_PATH, e);
        }
    }
}