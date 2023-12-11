package com.itbootcamp.EjercicioStarWars.service;

import com.itbootcamp.EjercicioStarWars.dto.CharacterDto;
import com.itbootcamp.EjercicioStarWars.dto.response.CharacterResponseDto;
import com.itbootcamp.EjercicioStarWars.entity.Character;

import java.util.List;

public interface ICharacterService {

    List<CharacterResponseDto> findAll();
    CharacterDto saveCharacter(CharacterDto newCharacter);
    List<CharacterResponseDto> findByName(String name);

}
