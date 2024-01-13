package com.ejercicio.Movies.service;

import com.ejercicio.Movies.dto.SerieDTO;
import com.ejercicio.Movies.model.Serie;
import com.ejercicio.Movies.repository.ISerieRepository;
import com.ejercicio.Movies.service.Interface.ISerieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {
    private ISerieRepository serieRepository;

    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> findSeriesWithMoreThanNumberOfSeasons(int numberOfSeasons) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Serie> series = serieRepository.findSeriesWithMoreThanNumberOfSeasons(numberOfSeasons);

        return series.stream()
                .map(serie -> mapper.convertValue(serie, SerieDTO.class))
                .toList();
    }
}
