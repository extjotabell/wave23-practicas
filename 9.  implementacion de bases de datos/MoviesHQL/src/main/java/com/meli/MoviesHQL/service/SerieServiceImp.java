package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.SerieDto;
import com.meli.MoviesHQL.model.Serie;
import com.meli.MoviesHQL.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImp implements SerieService {

    SerieRepository serieRepository;

    public SerieServiceImp(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDto> findBySeasonsCountGreaterThanEqual(Integer seasons) {
        List<Serie> series = serieRepository.findBySeasonsCountGreaterThanEqual(seasons);
        return series.stream().map(SerieDto::new).toList();
    }

}
