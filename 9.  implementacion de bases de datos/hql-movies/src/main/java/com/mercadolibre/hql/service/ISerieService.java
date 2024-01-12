package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> findAllByMinimumNumberOfSeasons(Integer numberSeasons);
}
