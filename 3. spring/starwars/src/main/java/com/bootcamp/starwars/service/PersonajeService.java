package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    private final IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDTO> getAllPersonajes(){
        return personajeRepository.getAllPersonajes();
    }

    public List<PersonajeDTO> getPersonajesByName(String name){
        return personajeRepository.getPersonajeByName(name);
    }

}
