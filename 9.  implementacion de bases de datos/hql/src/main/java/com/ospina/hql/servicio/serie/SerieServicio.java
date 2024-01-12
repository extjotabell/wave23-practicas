package com.ospina.hql.servicio.serie;

import com.ospina.hql.modelo.dto.SeriesDto;

import java.util.List;

public interface SerieServicio {

    List<SeriesDto> encontrarSeriesConMasDeNTemporadas(int seasonCount);
}
