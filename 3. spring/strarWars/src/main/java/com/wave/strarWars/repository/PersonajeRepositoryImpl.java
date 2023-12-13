package com.wave.strarWars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wave.strarWars.entity.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRespository{

    List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepositoryImpl() {
        loadDataFromJson();
    }

    @Override
    public List<Personaje> findAllpersonajes() {
        return personajes;
    }

    @Override
    public void savePersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    @Override
    public List<Personaje> findPersonajesByName(String nombre) {
       return personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase())).collect(Collectors.toList());
    }

    public void loadDataFromJson(){

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                File file = new ClassPathResource("starwars.json").getFile();

                Personaje[] personajesMapeados = objectMapper.readValue(file, Personaje[].class);
                personajes.addAll(Arrays.asList(personajesMapeados));
            } catch (IOException e) {
                e.printStackTrace();
                //throw new JsonReadException("Error al leer el archivo JSON");
            }
        }

}
