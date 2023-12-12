package com.spring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.entity.StarWarsCharacter;
import com.spring.starwars.repository.interfaces.IStarWarsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.management.StandardEmitterMBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository {

    public List<StarWarsCharacter> loadCharacters() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacter>> typeRef = new TypeReference<>() {
        };
        List<StarWarsCharacter> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<StarWarsCharacter> findCharacters(String characterName) {
        return loadCharacters()
                .stream()
                .filter(x -> x.getName().toUpperCase().contains(characterName.toUpperCase()))
                .toList();
    }
}
