package com.wave.strarWars.service;

import com.wave.strarWars.dto.request.PersonajeDto;
import com.wave.strarWars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {


    public List<PersonajeDto> findAllpersonajes();

    public Personaje savePersonaje(Personaje personaje);

    public List<PersonajeDto> findPersonajesByName(String nombre);
}
