package com.starwars.startwars.service;

import com.starwars.startwars.dto.PersonajesDTO;

public interface IStarWarsService {
    PersonajesDTO find(String nombre);

}
