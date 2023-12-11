package com.ejercicio.starwars.repository;

import com.ejercicio.starwars.dto.response.ResponseCharacterDTO;
import com.ejercicio.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    List<Character> characters = new ArrayList<>();
    public CharacterRepositoryImpl() {
        loadDataBase();
    }

    private void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ResponseCharacterDTO> findCharacters(String query) {
        ObjectMapper mapper = new ObjectMapper();

        return characters.stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()))
                .map(character -> {
                    ResponseCharacterDTO dto = new ResponseCharacterDTO();

                    dto.setName(character.getName());
                    dto.setHeight(character.getHeight());
                    dto.setMass(character.getMass());
                    dto.setGender(character.getGender());
                    dto.setHomeworld(character.getHomeworld());
                    dto.setSpecies(character.getSpecies());

                    return dto;
                })
                .toList();
    }
}
