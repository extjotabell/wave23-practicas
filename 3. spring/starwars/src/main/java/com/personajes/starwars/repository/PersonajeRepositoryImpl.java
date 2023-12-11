package com.personajes.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajes.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements  IPersonajeRepository{

    private List<Personaje> data = new ArrayList<>();

    public PersonajeRepositoryImpl() { loadData(); }
    @Override
    public List<Personaje> findAll() {
        return data;
    }

    public void loadData(){
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        try {
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
