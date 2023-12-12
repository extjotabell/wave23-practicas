package com.starwars.practice.service;

import com.starwars.practice.dto.CharacterDTO;
import com.starwars.practice.dto.CharactersDTO;
import com.starwars.practice.entity.Character;
import com.starwars.practice.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {
    @Autowired
    private ICharacterRepository icr;

    @Override
    public CharactersDTO getCharacters(String name) {
        List<Character> characters = icr.findAll(name);
        List<CharacterDTO> filteredCharacters = characters.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .map(p -> new CharacterDTO(
                        p.getName(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies(),
                        p.getHeight(),
                        p.getMass()
                ))
                .collect(Collectors.toList());

        return new CharactersDTO(filteredCharacters);
    }
}
