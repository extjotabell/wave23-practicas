package com.ospina.starWars.repositorio;

import com.ospina.starWars.modelo.entidad.Personaje;

import java.io.FileNotFoundException;
import java.util.List;

public interface RepositorioStarWars {
    public List<Personaje> obtenerTodos() throws FileNotFoundException;
}
