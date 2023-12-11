package org.ejercicio.starwars.service;

import org.ejercicio.starwars.dto.CharacterDto;
import org.ejercicio.starwars.entity.Character;
import org.ejercicio.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDto> findCharactersByName(String name) {
        List<Character> aux = characterRepository.findCharactersByName(name);
        return aux.stream()
                .map(character -> new CharacterDto(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                )).toList();
    }
}
