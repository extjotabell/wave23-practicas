package com.mercadolibre.deportistas.service;

import com.mercadolibre.deportistas.dto.PersonDTO;
import com.mercadolibre.deportistas.dto.SportDTO;
import com.mercadolibre.deportistas.entity.Sport;

import java.util.List;

public interface IDeportistaService {

    List<SportDTO> findSports();

    List<String> findSport(String name);

    List<PersonDTO> findSportsPersons();
}
