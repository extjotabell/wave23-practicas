package com.example.covid.service;

import com.example.covid.dto.PersonaDto;

import java.util.List;

public interface IPersonaService {
    List<PersonaDto> getAllPersons();

    List<PersonaDto> getDangerPerson();
}
