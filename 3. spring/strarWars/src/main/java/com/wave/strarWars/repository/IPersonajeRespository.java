package com.wave.strarWars.repository;

import com.wave.strarWars.entity.Personaje;

import java.util.ArrayList;
import java.util.List;

public interface IPersonajeRespository {


    public List<Personaje> findAllpersonajes();

    public void savePersonaje(Personaje personaje);

    public List<Personaje> findPersonajesByName(String nombre);

}
