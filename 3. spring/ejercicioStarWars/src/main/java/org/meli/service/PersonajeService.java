package org.meli.service;

import org.meli.dto.PersonajeResponseDTO;
import org.meli.model.Personaje;
import org.meli.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository repo;

    public List<PersonajeResponseDTO> getAllPersonajes(){
        List<Personaje> personajes = repo.getAllPersonajes();
        return personajes.stream().map(PersonajeResponseDTO::personajeToDTO).toList();
    }

    public List<PersonajeResponseDTO> getPersonajeByName(String name){
        List<Personaje> personajes = repo.getPersonajeByName(name);
        return personajes.stream().map(PersonajeResponseDTO::personajeToDTO).toList();
    }
}
