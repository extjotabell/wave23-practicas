package com.meli.movies.service;

import com.meli.movies.dto.SerieDTO;
import com.meli.movies.dto.SeriesDTO;
import com.meli.movies.repository.ISerieRepository;
import com.meli.movies.util.SerieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    ISerieRepository repository;

    public SerieServiceImpl(ISerieRepository repository) { this.repository = repository; }

    @Override
    public SeriesDTO findBySeasonGreaterThan(Integer seasons) {
        List<SerieDTO> series = repository.findBySeasonGreaterThan(seasons).stream()
                .map(SerieMapper::map)
                .toList();

        return new SeriesDTO(series);
    }
}
