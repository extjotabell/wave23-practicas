package com.starwars.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.entity.Personaje;
import com.starwars.starwars.repository.PersonajeRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BuscarPersonajeServiceImpl implements IBuscarPersonajeService {

    @Autowired
    private PersonajeRepositoryImpl personajeRepository;

    @Override
    public List<PersonajeDTO> buscar(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonajeDTO> respuesta = new ArrayList<>();

        List<Personaje> personaList = personajeRepository.buscarPersonaje(nombre);

        personaList.stream().forEach(p-> {
            respuesta.add(mapper.convertValue(p,PersonajeDTO.class));
        });

        return respuesta;
    }

    @Override
    public List<PersonajeDTO> mostrar() {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonajeDTO> respuesta = new ArrayList<>();

        List<Personaje> personaList = personajeRepository.mostrar();

        personaList.stream().forEach(p-> {
            respuesta.add(mapper.convertValue(p,PersonajeDTO.class));
        });

        return respuesta;
    }
}
