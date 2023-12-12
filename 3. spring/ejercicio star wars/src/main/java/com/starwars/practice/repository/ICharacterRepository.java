package com.starwars.practice.repository;

import com.starwars.practice.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findAll(String name);
}
