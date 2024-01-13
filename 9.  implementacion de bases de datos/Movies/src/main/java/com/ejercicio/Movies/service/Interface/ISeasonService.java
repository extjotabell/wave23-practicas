package com.ejercicio.Movies.service.Interface;

import com.ejercicio.Movies.dto.SeasonDTO;
import com.ejercicio.Movies.model.Season;

import java.util.List;

public interface ISeasonService {
    List<SeasonDTO> findSeasonsByActor(String fullName);
}
