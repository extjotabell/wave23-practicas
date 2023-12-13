package com.spring.starwars.service;

import com.spring.starwars.DTO.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStarWarsService {
    List<PersonajeDTO> findByName(String name);
    List<PersonajeDTO> findAll();
}
