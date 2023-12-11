package com.starwars.startwars.service;

import com.starwars.startwars.dto.PersonajeDTO;
import com.starwars.startwars.dto.PersonajesDTO;
import com.starwars.startwars.repository.IStarWarsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starwars.startwars.repository.StarWarsRepositoryImp;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarWarsServiceImp implements IStarWarsService {

    @Autowired
    private StarWarsRepositoryImp starWarsRepositoryImp;

    @Override
    public PersonajesDTO find(String nombre) {
        return new PersonajesDTO(starWarsRepositoryImp.find(nombre).stream().map(p -> new PersonajeDTO(p.getName(), p.getGender(), p.getHomeWorld(), p.getSpecies(), p.getHeight(), p.getMass())).toList());
    }
}
