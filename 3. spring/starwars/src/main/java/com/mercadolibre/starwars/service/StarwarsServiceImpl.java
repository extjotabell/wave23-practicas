package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDto;
import com.mercadolibre.starwars.dto.CharactersDto;
import com.mercadolibre.starwars.entity.Character;
import com.mercadolibre.starwars.repository.StarwarsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarwarsServiceImpl implements IStarwarsService {
    @Autowired
    StarwarsRepositoryImpl repository;

    @Override
    public CharactersDto findCharacterByName(String name) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<CharacterDto> dto = new ArrayList<>();
        List<Character> characters = repository.findCharacterByName(name);

        for (Character character : characters) {
            dto.add(mapper.convertValue(character, CharacterDto.class));
        }

        return new CharactersDto(dto);
    }
}
