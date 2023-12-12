package com.example.personajesstarwars.service;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.repository.RepositoryPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServicePersonajeImpl implements ServicePersonaje{
    @Autowired
    private final RepositoryPersonaje repositoryPersonaje;

    public ServicePersonajeImpl(RepositoryPersonaje repositoryPersonaje) {
        this.repositoryPersonaje = repositoryPersonaje;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {
        return repositoryPersonaje.getPersonajes()
                .stream()
                .filter(p->p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
