package com.meli.starwars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.repository.ICharacterRepository;
import com.meli.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        return characterRepository.findAll().stream()
                                            .map(c ->objectMapper.convertValue(c, CharacterDTO.class))
                                            .toList();
    }

    @Override
    public List<CharacterDTO> findAllFilterByName(String name) {
        return this.findAll().stream()
                             .filter( c -> c.getName().contains(name))
                             .toList();
    }

}
