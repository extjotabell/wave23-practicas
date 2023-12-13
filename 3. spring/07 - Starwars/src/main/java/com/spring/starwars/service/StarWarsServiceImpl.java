package com.spring.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.DTO.PersonajeDTO;
import com.spring.starwars.repository.StarWarsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService{
    StarWarsRepositoryImpl starWarsRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public StarWarsServiceImpl(StarWarsRepositoryImpl starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {
        return starWarsRepository.findByName(name).stream()
                .map(PersonajeDTO::new)
                .toList();
    }

    @Override
    public List<PersonajeDTO> findAll() {
        return starWarsRepository.findAll().stream()
                .map(personaje -> mapper.convertValue(personaje,PersonajeDTO.class))
                .toList();
    }

}
