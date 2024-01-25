package com.bootcampmeli.personajesStarWars.repository;
import com.bootcampmeli.personajesStarWars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> buscarPersonajePorNombre(String query);
}
