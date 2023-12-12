package com.mercadolibre.starWars.service;

import com.mercadolibre.starWars.dto.CharacterDto;
import com.mercadolibre.starWars.entitiy.Character;

import java.io.FileNotFoundException;
import java.util.List;

public interface ICharacterService {
    List<CharacterDto> findAll();
    List<CharacterDto> getCharacterByName(String name);
}
