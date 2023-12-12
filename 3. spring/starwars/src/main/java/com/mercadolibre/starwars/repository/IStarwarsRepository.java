package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.entity.Character;

import java.util.List;

public interface IStarwarsRepository {
    List<Character> findCharacterByName(String name) throws Exception;
}
