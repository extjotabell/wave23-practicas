package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.dto.CharacterDto;
import com.meli.starwars.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepositoryImp implements StarWarsRepository {
    private final List<Character> database;

    public StarWarsRepositoryImp() {
        this.database = loadJSON();
    }

    private List<Character> loadJSON() {
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};

        List<Character> characters = null;

        try {
            characters = objectMapper.readValue(jsonFile, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }

    @Override
    public List<Character> findCharacters(String query) {
        return database.stream()
            .filter(character -> {
                String nameLowerCase = character.getName().toLowerCase();
                String queryLowerCase = query.toLowerCase();

                return nameLowerCase.contains(queryLowerCase);
            })
            .toList();
    }
}
