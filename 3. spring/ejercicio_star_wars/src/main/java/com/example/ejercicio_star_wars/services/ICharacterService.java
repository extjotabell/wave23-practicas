package com.example.ejercicio_star_wars.services;

import com.example.ejercicio_star_wars.dtos.request.CharacterDto;

import java.util.List;

public interface ICharacterService {
    List<CharacterDto> findCharacter(String Variable) throws Exception;
}
