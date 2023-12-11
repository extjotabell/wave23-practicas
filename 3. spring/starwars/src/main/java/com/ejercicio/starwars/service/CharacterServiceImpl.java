package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.response.ResponseCharacterDTO;
import com.ejercicio.starwars.repository.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {
    @Autowired
    CharacterRepositoryImpl repository;

    @Override
    public List<ResponseCharacterDTO> findCharacters(String query) {
        return repository.findCharacters(query);
    }
}
