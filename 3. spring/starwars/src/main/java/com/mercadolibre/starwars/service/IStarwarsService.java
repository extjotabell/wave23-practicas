package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharactersDto;

public interface IStarwarsService {
    CharactersDto findCharacterByName(String name) throws Exception;
}
