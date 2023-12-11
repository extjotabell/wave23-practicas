package com.starwars.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        this.personajes = cargarDatos();
    }

    @Override
    public List<Personaje> buscarPersonaje(String nombre) {
        List<Personaje> personajes = new ArrayList<>();

        for (Personaje p : this.personajes) {
            if (p.getName().toLowerCase().contains(nombre.toLowerCase())) {
                personajes.add(p);
            }
        }

        return personajes;
    }

    @Override
    public List<Personaje> mostrar() {
        return personajes;
    }

    private List<Personaje> cargarDatos() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
        System.out.println("ENTRO ACA");
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
