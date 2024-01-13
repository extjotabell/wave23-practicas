package com.ejercicio.Movies.service;

import com.ejercicio.Movies.dto.SeasonDTO;
import com.ejercicio.Movies.model.Season;
import com.ejercicio.Movies.repository.ISeasonRepository;
import com.ejercicio.Movies.service.Interface.ISeasonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements ISeasonService {
    private ISeasonRepository seasonRepository;

    public SeasonServiceImpl(ISeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<SeasonDTO> findSeasonsByActor(String fullName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Season> seasons = seasonRepository.findSeasonsByActor(fullName);

        return seasons.stream()
                .map(season -> mapper.convertValue(season, SeasonDTO.class))
                .toList();
    }
}
