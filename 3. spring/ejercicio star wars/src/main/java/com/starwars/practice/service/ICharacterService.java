package com.starwars.practice.service;

import com.starwars.practice.dto.CharactersDTO;

public interface ICharacterService {
    CharactersDTO getCharacters(String name);
}
