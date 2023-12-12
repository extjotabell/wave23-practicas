package com.spring.starwars.service;

import com.spring.starwars.dto.StarWarsCharacterDto;
import com.spring.starwars.entity.StarWarsCharacter;
import com.spring.starwars.repository.StarWarsRepositoryImpl;
import com.spring.starwars.service.interfaces.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService {

    @Autowired
    private StarWarsRepositoryImpl _repository;

    @Override
    public List<StarWarsCharacterDto> findCharacter(String characterName) {
        return _repository.findCharacters(characterName).stream().map(this::convertToDto).toList();
    }

    private StarWarsCharacterDto convertToDto(StarWarsCharacter character) {
        return new StarWarsCharacterDto(
                character.getName(),
                character.getGender(),
                character.getHomeworld(),
                character.getSpecies(),
                character.getHeight(),
                character.getMass());
    }
}