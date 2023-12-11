package com.mercadolibre.starWars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starWars.entity.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import utils.exception.JsonReadException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link ICharacterRepository} interface providing access
 * to Star Wars character data from a JSON file.
 * This repository loads character data from the "starwars.json" file using Jackson ObjectMapper
 * and provides methods to retrieve information about Star Wars characters.
 */
@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {

    /**
     * List containing Star Wars character objects.
     */
    private List<Character> characters;

    /**
     * Constructs a new {@code CharacterRepositoryImpl} and initializes the list of characters
     * by loading data from the "starwars.json" file.
     *
     * @throws JsonReadException If an error occurs while reading the JSON file.
     */
    public CharacterRepositoryImpl() {
        loadCharactersFromJson();
    }

    /**
     * Loads Star Wars character data from the "starwars.json" file using Jackson ObjectMapper.
     *
     * @throws JsonReadException If an error occurs while reading the JSON file.
     */
    private void loadCharactersFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("starwars.json").getFile();

            Character[] characterArray = objectMapper.readValue(file, Character[].class);
            characters = Arrays.asList(characterArray);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonReadException("Error al leer el archivo JSON");
        }
    }

    /**
     * Retrieves a list of all Star Wars characters.
     *
     * @return List of Star Wars character objects.
     */
    @Override
    public List<Character> getAllCharacters() {
        return characters;
    }

    /**
     * Retrieves a list of Star Wars characters whose names contain the specified search string,
     * case-insensitive.
     *
     * @param name The search string to match against character names.
     * @return List of matching Star Wars character objects.
     */
    @Override
    public List<Character> getCharacterByName(String name) {
        return characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}