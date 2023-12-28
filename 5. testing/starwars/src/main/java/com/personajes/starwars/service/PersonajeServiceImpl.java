package com.personajes.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajes.starwars.dto.request.PersonajeDto;
import com.personajes.starwars.entity.Personaje;
import com.personajes.starwars.repository.PersonajeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl {
    @Autowired
    PersonajeRepositoryImpl repository;

    public List<PersonajeDto> findMatches(String pattern){
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = repository.findAll();
        List<PersonajeDto> respuesta = personajes.stream().
                filter(personaje -> personaje.getName().contains(pattern)).
                map(personaje -> mapper.convertValue(personaje,PersonajeDto.class)).
                toList();
        return respuesta;
    }


}
