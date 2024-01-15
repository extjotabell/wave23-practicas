package com.mercadolibre.movieshql.services.impl;

import com.mercadolibre.movieshql.model.dtos.SeriesDTO;
import com.mercadolibre.movieshql.repositories.ISeriesRepository;
import com.mercadolibre.movieshql.services.ISeriesService;
import com.mercadolibre.movieshql.utils.MapperDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeriesServiceImpl implements ISeriesService {

    private final ISeriesRepository seriesRepository;

    public SeriesServiceImpl(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    @Transactional
    public List<SeriesDTO> findSeriesHigherThanSeasonsValue(Integer seasons) {
       return seriesRepository.findSeriesBySeasons(seasons).stream().map(MapperDTO::mapToSerieDTO).toList();
    }
}
