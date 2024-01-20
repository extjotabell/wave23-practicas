package com.implementationbd.movie.service;

import com.implementationbd.movie.model.dto.SeriesDto;
import com.implementationbd.movie.repository.ISerieRepository;
import com.implementationbd.movie.service.interfaces.ISeriesService;
import com.implementationbd.movie.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeriesServiceImpl implements ISeriesService {

    @Autowired
    ISerieRepository repository;

    @Override
    public List<SeriesDto> getSeriesWithMoreThanSeasons(int seasonCount) {
        return repository.getSeriesWithMoreThanSeasons(seasonCount)
                .stream()
                .map(UtilConvert::toDto)
                .toList();
    }
}
