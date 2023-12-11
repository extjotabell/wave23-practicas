package com.ejercicio.starwars.repository;

import com.ejercicio.starwars.dto.response.ResponseCharacterDTO;

import java.util.List;

public interface ICharacterRepository {
    List<ResponseCharacterDTO> findCharacters(String query);
}
