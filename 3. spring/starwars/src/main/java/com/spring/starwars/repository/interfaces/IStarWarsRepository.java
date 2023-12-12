package com.spring.starwars.repository.interfaces;

import com.spring.starwars.entity.StarWarsCharacter;

import java.util.List;

public interface IStarWarsRepository {
    List<StarWarsCharacter> findCharacters(String characterName);
}
