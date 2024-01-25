package com.example.covid.service;

import com.example.covid.dto.PersonaDto;
import com.example.covid.entity.Persona;
import com.example.covid.repository.PersonaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{

    final
    PersonaRepositoryImpl repository;

    public PersonaServiceImpl(PersonaRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonaDto> getAllPersons() {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> personas = repository.findAll();

        for (Persona persona: personas
        ) {
            respuesta.add(new PersonaDto(persona.getId(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getEdad(),
                    persona.getSintoma()));
        }
        return respuesta;
    }

    @Override
    public List<PersonaDto> getDangerPerson() {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> personas = repository.findAll().stream().filter(persona -> persona.getEdad() >= 60).toList();

        for (Persona persona: personas
        ) {
            respuesta.add(new PersonaDto(persona.getId(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getEdad(),
                    persona.getSintoma()));
        }
        return respuesta;
    }
}
