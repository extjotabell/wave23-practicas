package com.starwars.starwars.service;

import com.starwars.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IBuscarPersonajeService {
    List<PersonajeDTO> buscar(String nombre);

    List<PersonajeDTO> mostrar();
}
