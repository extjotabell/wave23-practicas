package com.mercadolibre.starWars.service;

import com.mercadolibre.starWars.dto.CharacterResponseDTO;

import java.util.List;

/**
 * Service interface for managing Star Wars characters.
 */
public interface ICharacterService {

    /**
     * Retrieves a list of all characters from the Star Wars universe.
     *
     * @return List of CharacterResponseDTO containing details of all characters.
     */
    List<CharacterResponseDTO> getAllCharacters();

    /**
     * Retrieves a list of characters by their name from the Star Wars universe.
     *
     * @param name The name of the character or a portion of the name to search for.
     * @return List of CharacterResponseDTO containing details of characters matching the provided name.
     */
    List<CharacterResponseDTO> getCharacterByName(String name);

}
