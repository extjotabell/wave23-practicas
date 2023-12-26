package org.ejercicio.starwars.service;

import org.ejercicio.starwars.dto.CharacterDto;

import java.util.List;

public interface ICharacterService {

    List<CharacterDto> findCharactersByName(String name);
}
