package com.starwars.practice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.practice.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoryImp implements ICharacterRepository {
    private final List<Character> characters = loadData();

    public CharacterRepositoryImp() {
        this.loadData();
    }

    private List<Character> loadData() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }

    @Override
    public List<Character> findAll(String name) {
        System.out.println("llega al repository imp");
        return characters;
    }
}
