package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.bootcamp.starwars.dto.PersonajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImplementation implements IPersonajeRepository{

    private final List<PersonajeDTO> personajes;

    public PersonajeRepositoryImplementation(){
        this.personajes = cargarPersonajes();
    }

    @Override
    public List<PersonajeDTO> getAllPersonajes(){
        return personajes;
    }

    @Override
    public List<PersonajeDTO> getPersonajeByName(String name){
        return personajes.stream()
                .filter(personajeDTO -> personajeDTO.getName().contains(name))
                .toList();
    }

    private List<PersonajeDTO> cargarPersonajes(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<>(){};
        List<Personaje> personajesList = null;
        try{
            personajesList = objectMapper.readValue(archivo, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        List<PersonajeDTO> personajes = personajesList.stream()
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies(), personaje.getHeight(), personaje.getMass()))
                .collect(Collectors.toList());

        return personajes;
    }

}
