package com.meli.starwars.repository;

import java.util.List;
import com.meli.starwars.entity.Character;

public interface ICharacterRepository {
    List<Character> findAll();
}
