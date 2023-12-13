package com.example.ejercicio_covid.service;

import com.example.ejercicio_covid.dto.PersonaDto;
import com.example.ejercicio_covid.dto.SintomaDto;
import com.example.ejercicio_covid.entitie.Persona;
import com.example.ejercicio_covid.entitie.Sintoma;
import com.example.ejercicio_covid.repository.PersonaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    PersonaRepositoryImpl repository;
    @Override
    public List<PersonaDto> getAllPersons() {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> PersonaList = repository.findAll();

        for (Persona aux: PersonaList
        ) {
            respuesta.add(new PersonaDto(aux.getId(),
                    aux.getNombre(),
                    aux.getApellido(),
                    aux.getEdad(),
                    aux.getSintoma()));
        }
        return respuesta;
    }

    @Override
    public List<PersonaDto> getDangerPerson() {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> PersonaList = repository.findAll().stream().filter(persona -> persona.getEdad() >= 60).toList();

        for (Persona aux: PersonaList
        ) {
            respuesta.add(new PersonaDto(aux.getId(),
                    aux.getNombre(),
                    aux.getApellido(),
                    aux.getEdad(),
                    aux.getSintoma()));
        }
        return respuesta;
    }
}
