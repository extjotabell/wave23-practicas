package com.jpa.hql.service;

import com.jpa.hql.model.dto.SerieDTO;

import java.util.Set;

public interface ISerieService {
    Set<SerieDTO> getSeriesWithNumberOfSeasonsGreaterThan(Integer numberSeasons);
}
