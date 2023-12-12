package com.mercadolibre.starWars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mercadolibre.starWars.dto.CharacterDto;
import com.mercadolibre.starWars.entitiy.Character;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository{
    private List<Character> characters;

    public CharacterRepositoryImpl() {
        initializeCharacters();
    }

    public void initializeCharacters(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars.json");
            List<CharacterDto> personajesJson = Arrays.asList(objectMapper.readValue(inputStream, CharacterDto[].class));
            this.characters = personajesJson.stream()
                    .map(CharacterDto::dtoToCharacter)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            this.characters = new ArrayList<>();
        }
    }
    @Override
    public List<Character> loadAll() {
        return characters;
    }

    @Override
    public List<Character> getCharactersByName(String name){
        String searchName = name.toLowerCase();
        return characters.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(searchName))
                .toList();
    }
}
