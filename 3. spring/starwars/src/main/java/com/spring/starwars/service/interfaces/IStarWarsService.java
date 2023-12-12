package com.spring.starwars.service.interfaces;

import com.spring.starwars.dto.StarWarsCharacterDto;

import java.util.List;

public interface IStarWarsService {
    List<StarWarsCharacterDto> findCharacter(String characterName);
}
