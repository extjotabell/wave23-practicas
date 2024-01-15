package com.example.ejercicioHQL.service;

import com.example.ejercicioHQL.dto.SeriesDto;
import com.example.ejercicioHQL.model.Series;

import java.util.List;

public interface ISeriesService {

    public List<SeriesDto> findBySeasonsCount(Integer n);

}
