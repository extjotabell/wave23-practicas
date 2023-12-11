package com.example.ejercicio_star_wars.repositorys;

import com.example.ejercicio_star_wars.entities.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findAll();
}
