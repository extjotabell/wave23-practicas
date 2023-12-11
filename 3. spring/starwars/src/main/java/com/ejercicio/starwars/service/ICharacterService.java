package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.response.ResponseCharacterDTO;

import java.util.List;

public interface ICharacterService{
    List<ResponseCharacterDTO> findCharacters(String query);
}
