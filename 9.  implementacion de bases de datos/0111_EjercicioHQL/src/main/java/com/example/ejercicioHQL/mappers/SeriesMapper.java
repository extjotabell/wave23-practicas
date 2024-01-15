package com.example.ejercicioHQL.mappers;

import com.example.ejercicioHQL.dto.SeriesDto;
import com.example.ejercicioHQL.model.Series;

public class SeriesMapper {

    private SeriesMapper seriesMapper;

    public SeriesMapper(){

    }

    public SeriesDto mapSeriesDto(Series series){
        return new SeriesDto(
                series.getId(),
                series.getTitle(),
                series.getReleaseDate(),
                series.getEndDate()
        );
    }

}
