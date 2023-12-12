package com.meli.starwars.service;

import com.meli.starwars.dto.CharacterDto;
import com.meli.starwars.entity.Character;
import com.meli.starwars.repository.StarWarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StarWarsService {

    private StarWarsRepository starWarsRepository;

    public List<CharacterDto> findCharacters(String query) {
        List<Character> characters = starWarsRepository.findCharacters(query);

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
