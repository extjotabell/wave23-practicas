package com.ospina.deportistas.servicio.persona;

import com.ospina.deportistas.entidad.PersonaDeportistaDTO;

import java.util.List;

public interface PersonaServicio {
    List<PersonaDeportistaDTO> obtenerTodos();
}
