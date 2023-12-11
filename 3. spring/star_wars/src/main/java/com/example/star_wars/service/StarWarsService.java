package com.example.star_wars.service;

import com.example.star_wars.dto.CharacterDTO;
import com.example.star_wars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements com.example.star_wars.service.Service {

    private final CharacterRepository characterRepository;

    public StarWarsService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> filterByName(String filterParam) {
        return characterRepository.filterByName(filterParam).stream()
                .map(CharacterDTO::new).toList();
    }
}
