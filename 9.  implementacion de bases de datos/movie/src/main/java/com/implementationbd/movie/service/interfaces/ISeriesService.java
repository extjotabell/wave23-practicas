package com.implementationbd.movie.service.interfaces;

import com.implementationbd.movie.model.dto.SeriesDto;

import java.util.List;

public interface ISeriesService {
    List<SeriesDto> getSeriesWithMoreThanSeasons(int seasonCount);
}
