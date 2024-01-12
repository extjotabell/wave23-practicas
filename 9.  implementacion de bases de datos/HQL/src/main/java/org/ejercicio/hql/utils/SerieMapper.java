package org.ejercicio.hql.utils;

import org.ejercicio.hql.model.dto.SerieDTO;
import org.ejercicio.hql.model.entity.Serie;

public class SerieMapper {
    public static SerieDTO serieMap(Serie serie) {
        return new SerieDTO(serie.getId(), serie.getCreatedAt(), serie.getUpdatedAt(), serie.getTitle(), serie.getReleasDate(), serie.getEndate(), serie.getGenreId());
    }
}
