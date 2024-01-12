package com.meli.movies.services.impl;

import com.meli.movies.dtos.response.SerieDTO;
import com.meli.movies.mappers.SerieMapper;
import com.meli.movies.repositories.ISerieRepository;
import com.meli.movies.services.ISerieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    private final ISerieRepository serieRepository;

    public SerieService(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> getSeriesBySeasons(Integer seasons) {
        return serieRepository.getSeriesBySeasons(seasons).stream()
                .map(SerieMapper::toDTO)
                .toList();
    }
}
