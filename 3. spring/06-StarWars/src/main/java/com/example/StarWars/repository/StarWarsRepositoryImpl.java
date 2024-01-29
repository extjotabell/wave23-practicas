package com.starwars.startwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.startwars.entity.PersonajeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class StarWarsRepositoryImp implements IStarWarsRepository {

    private List<PersonajeEntity> personajes;

    public StarWarsRepositoryImp() {
        personajes = new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeEntity>> typeRef = new TypeReference<>() {};
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PersonajeEntity> find(String nombre) {
        return personajes.stream()
                .filter( personajeEntity -> personajeEntity.getName().toUpperCase().contains(nombre.toUpperCase())).toList();
    }

    @Override
    public List<PersonajeEntity> findAll() {
        return personajes;
    }
}