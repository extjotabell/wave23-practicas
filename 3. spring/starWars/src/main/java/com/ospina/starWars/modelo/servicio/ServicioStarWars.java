package com.ospina.starWars.modelo.servicio;

import com.ospina.starWars.modelo.dto.PersonajeDTO;

import java.util.List;

public interface ServicioStarWars {
    public List<PersonajeDTO> buscarPersonajesPorNombre(String nombre);
}
