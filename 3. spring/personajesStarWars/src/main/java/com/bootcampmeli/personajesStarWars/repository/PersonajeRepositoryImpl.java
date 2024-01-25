package com.bootcampmeli.personajesStarWars.repository;

import com.bootcampmeli.personajesStarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

public class PersonajeRepositoryImpl implements IPersonajeRepository{
    List<Personaje> personajes;
    public PersonajeRepositoryImpl(){
        personajes = loadCharacters();
    }
    private List<Personaje> loadCharacters() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> ingredients = null;

        try {
            ingredients = mapper.readValue(file, typeRef);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public List<Personaje> buscarPersonajePorNombre(String query) {
        return personajes.stream()
                .filter(personaje ->
                        personaje.getName().toLowerCase()
                                .contains(query.toLowerCase())).toList();
    }
}
