package com.personajesStarWars.personajesStarWars.service;
import com.personajesStarWars.personajesStarWars.dto.PersonajeDto;
import com.personajesStarWars.personajesStarWars.entity.Personaje;
import com.personajesStarWars.personajesStarWars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    PersonajeRepository repository;

    @Override
    public List<PersonajeDto> getAll() {
        return repository.getAll().stream()
                .map(e -> new PersonajeDto(e.getName(), e.getHeight(), e.getMass(), e.getGender(), e.getHomeworld(), e.getSpecies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDto> findByName(String name) {
        List<Personaje> personajes = repository.findByName(name);
        List<PersonajeDto> resultados = new ArrayList<>();

        for (Personaje personaje : personajes) {
            resultados.add(new PersonajeDto(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeworld(),
                    personaje.getSpecies()
            ));
        }
        return resultados;
    }





}
