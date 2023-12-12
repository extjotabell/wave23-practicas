package com.meli.starwars.repository;

import com.meli.starwars.entity.Character;

import java.util.List;

public interface StarWarsRepository {
    List<Character> findCharacters(String query);
}
