package com.itbootcamp.EjercicioStarWars.repository;

import com.itbootcamp.EjercicioStarWars.entity.Character;

import java.util.List;

public interface ICharacterRepository {

    List<Character> findAll();
    void saveCharacter(Character newCharacter);
    List<Character> findByName(String name);

}
