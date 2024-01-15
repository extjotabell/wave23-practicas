package com.example.ejercicioHQL.service.impl;

import com.example.ejercicioHQL.dto.SeriesDto;
import com.example.ejercicioHQL.mappers.SeriesMapper;
import com.example.ejercicioHQL.model.Series;
import com.example.ejercicioHQL.repository.SeriesRepository;
import com.example.ejercicioHQL.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements ISeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    @Override
    public List<SeriesDto> findBySeasonsCount(Integer n) {
        SeriesMapper seriesMapper = new SeriesMapper();
        return seriesRepository.findBySeasonsNumber(n)
                .stream()
                .map(seriesMapper::mapSeriesDto)
                .toList();
    }
}
