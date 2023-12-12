package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarwarsRepositoryImpl implements IStarwarsRepository {

    List<Character> characters = new ArrayList<>();

    public StarwarsRepositoryImpl() {
        loadData();
    }

    private void loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Character>> typeReference = new TypeReference<>() {};
        List<Character> aux;
        try {
            aux = mapper.readValue(file, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        characters = aux;
    }

    @Override
    public List<Character> findCharacterByName(String name) throws Exception {
        List<Character> list = new ArrayList<>();
        for (Character character: characters) {
            if (character.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(character);
            }
        }
        if (list.isEmpty()) {
            throw new Exception("No existe el personaje llamado: " + name);
        }

        return list;
    }
}
