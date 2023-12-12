package com.personajesStarWars.personajesStarWars.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajesStarWars.personajesStarWars.entity.Personaje;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.ResourceUtils;

@Repository
public class PersonajeRepository implements IPersonsajeRepository {
    List<Personaje> data;

    public PersonajeRepository(){
        this.data = cargarJson();
    }

    private List<Personaje> cargarJson() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> personajes = null;

        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personajes;
    }

    @Override
    public List<Personaje> getAll() {
        return data;
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> resultados = new ArrayList<>();
        for (Personaje personaje : this.data) {
            if (personaje.getName().toLowerCase().contains(name.toLowerCase())) {
                resultados.add(personaje);
            }
        }
        return resultados;
    }
}
