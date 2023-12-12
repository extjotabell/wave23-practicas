package com.example.personajesstarwars.repository;

import com.example.personajesstarwars.dto.PersonajeDTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryPersonajeImpl implements RepositoryPersonaje {
    private final List<PersonajeDTO> personajes;

    @Override
    public List<PersonajeDTO> getPersonajes() {
        return personajes;
    }

    public RepositoryPersonajeImpl() {
        personajes=loadData();
    }

    private List<PersonajeDTO> loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {};
        List<PersonajeDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


}
