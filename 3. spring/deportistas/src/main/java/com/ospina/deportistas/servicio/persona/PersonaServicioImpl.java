package com.ospina.deportistas.servicio.persona;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.entidad.Persona;
import com.ospina.deportistas.entidad.PersonaDeportistaDTO;
import com.ospina.deportistas.servicio.deporte.DeporteServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServicioImpl implements PersonaServicio{

    @Autowired
    private DeporteServicio deporteServicio;

    private List<Deporte> listaDeportes;
    private List<Persona> personas;

    @PostConstruct
    public void init() {
        listaDeportes = deporteServicio.obtenerTodos();
        personas = List.of(
                new Persona("Juan", "Perez", 18, listaDeportes.get(0)),
                new Persona("Pedro", "Gomez", 20, listaDeportes.get(1)),
                new Persona("Maria", "Gonzalez", 25, listaDeportes.get(2)),
                new Persona("Luisa", "Garcia", 30, listaDeportes.get(3)),
                new Persona("Camila", "Rodriguez", 35, listaDeportes.get(4))
        );
    }

    @Override
    public List<PersonaDeportistaDTO> obtenerTodos() {
        return personas.stream()
                .map(persona -> new PersonaDeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}