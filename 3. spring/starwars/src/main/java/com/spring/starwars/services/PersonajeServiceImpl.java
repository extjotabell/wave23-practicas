package com.spring.starwars.services;

import com.spring.starwars.entities.Personaje;
import com.spring.starwars.dtos.PersonajeDto;
import com.spring.starwars.repositories.IPersonajeRepository;
import com.spring.starwars.repositories.PersonajeRepositoryImpl;
import com.spring.starwars.utils.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IPersonajeRepository personajeRepository;

    public List<PersonajeDto> findAll() {
        List<Personaje> personajes = personajeRepository.getPersonajes();
        return personajes.stream().map(PersonajeMapper::mapPersonajeToDto).toList();
    }

    public List<PersonajeDto> searchByName(String name) {
        List<Personaje> personajes = personajeRepository.getPersonajesByName(name);
        return personajes.stream().map(PersonajeMapper::mapPersonajeToDto).toList();
    }

}
