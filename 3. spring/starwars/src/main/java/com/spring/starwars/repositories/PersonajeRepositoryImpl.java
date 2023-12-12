package com.spring.starwars.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.spring.starwars.entities.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{
    private static final String FILE_PATH = "starwars.json";
    private final List<Personaje> personajesDB;

    public PersonajeRepositoryImpl() {
        this.personajesDB = loadJsonData();
    }

    private List<Personaje> loadJsonData() {
        File file = null;
        try {
            file = ResourceUtils.getFile(FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    public List<Personaje> getPersonajes() {
        return personajesDB;
    }
    public List<Personaje> getPersonajesByName(String name) {
        return personajesDB.stream().filter(p->p.getName().toLowerCase().contains(name)).toList();
    }
}
