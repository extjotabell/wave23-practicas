package com.spring.starwars.utils;

import com.spring.starwars.dtos.PersonajeDto;
import com.spring.starwars.entities.Personaje;

public class PersonajeMapper {

    public static PersonajeDto mapPersonajeToDto(Personaje p){
        return new PersonajeDto(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
    }
}
