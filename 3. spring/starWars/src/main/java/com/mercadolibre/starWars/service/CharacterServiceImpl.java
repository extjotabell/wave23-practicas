package com.mercadolibre.starWars.service;

import com.mercadolibre.starWars.dto.CharacterDto;
import com.mercadolibre.starWars.entitiy.Character;
import com.mercadolibre.starWars.repository.ICharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    ICharacterRepository repository;

    @Override
    public List<CharacterDto> findAll(){
        List<Character> characters = repository.loadAll();
        return characters.stream()
                .map(character -> new CharacterDto(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                ))
                .toList();
    }


    @Override
    public List<CharacterDto> getCharacterByName(String name){
        List<Character> characters = repository.getCharactersByName(name);
        return characters.stream()
                .map(character -> new CharacterDto(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                ))
                .toList();
    }


}
