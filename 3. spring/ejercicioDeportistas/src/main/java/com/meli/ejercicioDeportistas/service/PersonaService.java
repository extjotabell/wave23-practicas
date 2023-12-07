package com.meli.ejercicioDeportistas.service;

import com.meli.ejercicioDeportistas.model.dto.PersonaListResponseDTO;
import com.meli.ejercicioDeportistas.model.Persona;
import com.meli.ejercicioDeportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repo;

    public PersonaListResponseDTO getAllPeople(){
        List<Persona> personas = repo.getAllPersonas();
        return new PersonaListResponseDTO(
                personas.stream()
                        .map(Persona::toResponseDTO)
                        .toList()
        );

    }
}
