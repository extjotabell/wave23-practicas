package com.ospina.deportistas.servicio;

import com.ospina.deportistas.entidad.Persona;
import com.ospina.deportistas.entidad.PersonaDeportistaDTO;

import java.util.List;

public class PersonaServicioImpl implements PersonaServicio{

    private final List<Persona> personas = List.of(
            new Persona("Juan", "Perez", 18),
            new Persona("Pedro", "Perez", 19),
            new Persona("Maria", "Perez", 20),
            new Persona("Juan", "Perez", 21),
            new Persona("Pedro", "Perez", 22),
            new Persona("Maria", "Perez", 23)
    );

    @Override
    public List<PersonaDeportistaDTO> obtenerTodos() {
        return null;
    }
}
