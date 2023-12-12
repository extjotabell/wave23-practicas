package com.mercadolibre.starWars.repository;

import com.mercadolibre.starWars.entitiy.Character;

import java.io.FileNotFoundException;
import java.util.List;

public interface ICharacterRepository {

    List<Character> loadAll ();
    List<Character> getCharactersByName(String name);
}
