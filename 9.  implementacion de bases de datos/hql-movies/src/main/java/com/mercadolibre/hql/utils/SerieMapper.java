package com.mercadolibre.hql.utils;

import com.mercadolibre.hql.dto.SerieDTO;
import com.mercadolibre.hql.entity.Series;

public class SerieMapper {
    public static SerieDTO serieMap(Series serie) {
        return new SerieDTO(serie.getId(), serie.getCreatedAt(), serie.getUpdatedAt(), serie.getTitle(), serie.getReleaseDate(), serie.getEndDate());
    }
}
