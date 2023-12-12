package org.meli.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.meli.dto.PersonajeJsonDTO;
import org.meli.dto.PersonajeResponseDTO;
import org.meli.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonajeRepository {
    private List<Personaje> personajes;
    public PersonajeRepository(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars.json");
            List<PersonajeJsonDTO> personajesJson = Arrays.asList(objectMapper.readValue(inputStream, PersonajeJsonDTO[].class));
            personajes = personajesJson.stream().map(PersonajeJsonDTO::dtoToPersonaje).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Personaje> getAllPersonajes(){
        return personajes;
    }

    public List<Personaje> getPersonajeByName(String name){
        return personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name)).toList();
    }
}
