package com.ospina.starWars.modelo.servicio;

import com.ospina.starWars.modelo.dto.PersonajeDTO;
import com.ospina.starWars.modelo.entidad.Personaje;
import com.ospina.starWars.repositorio.RepositorioStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioStarWarsImpl implements ServicioStarWars {

    @Autowired
    RepositorioStarWars repositorioStarWars;

    @Override
    public List<PersonajeDTO> buscarPersonajesPorNombre(String nombre) {
        try {
            List<Personaje> todosLosPersonajes = repositorioStarWars.obtenerTodos();
            return todosLosPersonajes.stream()
                    .filter(personaje -> personaje.getName().contains(nombre))
                    .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeWorld(), personaje.getSpecies()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error encontrando personajes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
