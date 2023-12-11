package com.mercadolibre.starWars.repository;

import com.mercadolibre.starWars.entity.Character;

import java.util.List;

/**
 * Interface defining methods for accessing Star Wars character data.
 */
public interface ICharacterRepository {

    /**
     * Retrieves a list of all Star Wars characters.
     *
     * @return List of Star Wars character objects.
     */
    List<Character> getAllCharacters();

    /**
     * Retrieves a list of Star Wars characters whose names contain the specified search string.
     *
     * @param name The search string to match against character names.
     * @return List of matching Star Wars character objects.
     */
    List<Character> getCharacterByName(String name);
}
