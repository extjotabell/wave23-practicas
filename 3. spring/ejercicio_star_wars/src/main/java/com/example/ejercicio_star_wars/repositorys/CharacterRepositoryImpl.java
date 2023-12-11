package com.example.ejercicio_star_wars.repositorys;

import com.example.ejercicio_star_wars.entities.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {

    List<Character> data = new ArrayList<>();

    public CharacterRepositoryImpl() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        data = objectMapper.readValue(new File("/Users/mlackington/Desktop/Ejercicios Java/demoW23Dto/src/main/java/meli/demoW23Dto/repository/3. starwars.json"), new TypeReference<>() {
        });
    }


    @Override
    public List<Character> findAll() {
        return data;
    }
}

