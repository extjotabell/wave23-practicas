package com.wave.strarWars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wave.strarWars.dto.request.PersonajeDto;
import com.wave.strarWars.entity.Personaje;
import com.wave.strarWars.repository.PersonajeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    PersonajeRepositoryImpl repository;

    @Override
    public List<PersonajeDto> findAllpersonajes() {
        List<PersonajeDto> personajesDto = new ArrayList<>();
        List<Personaje> personajes = repository.findAllpersonajes();

        return mapPersonajesToPersonajesDTO(personajes);
    }

    @Override
    public Personaje savePersonaje(Personaje personaje) {
        ObjectMapper mapper = new ObjectMapper();


        //Personaje personaje = mapper.convertValue(personajeDto, Personaje.class);

        repository.savePersonaje(personaje);
        return personaje;
    }

    @Override
    public List<PersonajeDto> findPersonajesByName(String nombre) {
       List<Personaje> personajesPorNombre = repository.findPersonajesByName(nombre);

        return mapPersonajesToPersonajesDTO(personajesPorNombre);
    }


    private List<PersonajeDto> mapPersonajesToPersonajesDTO(List<Personaje> personajes) {
        return personajes.stream()
                .map(PersonajeServiceImpl::mapPersonajeToDTO)
                .collect(Collectors.toList());
    }

    public static PersonajeDto mapPersonajeToDTO(Personaje personaje) {
        return new PersonajeDto(
                personaje.getName(), personaje.getHeight(), personaje.getMass(),
                personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()
        );
    }
}
