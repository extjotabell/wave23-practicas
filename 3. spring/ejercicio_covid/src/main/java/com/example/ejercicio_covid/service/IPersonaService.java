package com.example.ejercicio_covid.service;

import com.example.ejercicio_covid.dto.PersonaDto;

import java.util.List;

public interface IPersonaService {
    List<PersonaDto> getAllPersons();

    List<PersonaDto> getDangerPerson();
}
