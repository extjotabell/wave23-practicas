package com.itbootcamp.EjercicioStarWars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbootcamp.EjercicioStarWars.dto.CharacterDto;
import com.itbootcamp.EjercicioStarWars.dto.response.CharacterResponseDto;
import com.itbootcamp.EjercicioStarWars.entity.Character;
import com.itbootcamp.EjercicioStarWars.repository.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Override
    public List<CharacterResponseDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<CharacterResponseDto> charactersDtoList = new ArrayList<>();
        List<Character> characterList = characterRepository.findAll();
        characterList
                .forEach(c -> {
                    charactersDtoList.add(mapper.convertValue(c, CharacterResponseDto.class));
                });
        return charactersDtoList;
    }

    @Override
    public CharacterDto saveCharacter(CharacterDto newCharacter) {
        return null;
    }

    @Override
    public List<CharacterResponseDto> findByName(String name) {
        List<CharacterResponseDto> charactersDtoList = new ArrayList<>();
        List<Character> characterList = characterRepository.findByName(name);
        if(!characterList.isEmpty()){
            ObjectMapper mapper = new ObjectMapper();
            characterList
                    .forEach(c -> {
                        charactersDtoList.add(mapper.convertValue(c, CharacterResponseDto.class));
                    });
        }
        return charactersDtoList;
    }
}
