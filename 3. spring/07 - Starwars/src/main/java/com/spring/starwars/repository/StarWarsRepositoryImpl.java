package com.spring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository{
    List<Personaje> personajesList;

    public StarWarsRepositoryImpl() throws IOException {
        this.personajesList = leerJson();
    }

    private List<Personaje> leerJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/starwars.json"));
        ObjectMapper om = new ObjectMapper();
        return om.readValue(reader, new TypeReference<>() {
        });
    }

    @Override
    public List<Personaje> findByName(String name) {
        return personajesList.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .toList();
    }

    @Override
    public List<Personaje> findAll() {
        return personajesList;
    }
}
