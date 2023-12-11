package com.meli.starwars.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Repository;
import com.meli.starwars.entity.Character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {

    private List<Character> characters;
    @Override
    public List<Character> findAll() {
        this.loadData();
        return characters;
    }

    private void loadData(){
        characters = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/starwars.json"));
            ObjectMapper objectMapper = new ObjectMapper();

            List<Character> listFromJson = objectMapper.readValue(reader,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Character.class));

            listFromJson.stream().forEach(c -> characters.add(c));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
