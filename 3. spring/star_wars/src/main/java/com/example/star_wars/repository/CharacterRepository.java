package com.example.star_wars.repository;

import com.example.star_wars.entity.Character;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Repository
public class CharacterRepository implements com.example.star_wars.repository.Repository {

    private List<Character> characters;

    @Override
    public List<Character> filterByName(String filterParam) {
        return characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(filterParam.toLowerCase())).toList();
    }

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Character[] characterArray = objectMapper.readValue(
                new File("src/main/resources/static/starwars.json"), Character[].class);
        characters = Arrays.asList(characterArray);
    }
}
