package com.ospina.hql.servicio.serie;

import com.ospina.hql.modelo.dto.SeriesDto;
import com.ospina.hql.repositorio.SerieRepositorio;
import com.ospina.hql.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServicioImpl implements SerieServicio{

    private final SerieRepositorio serieRepositorio;

    public SerieServicioImpl(SerieRepositorio serieRepositorio) {
        this.serieRepositorio = serieRepositorio;
    }

    @Override
    public List<SeriesDto> encontrarSeriesConMasDeNTemporadas(int seasonCount) {
        return DTOMapper.toSeriesDtoList(serieRepositorio.encontrarSeriesConMasDeNTemporadas(seasonCount));
    }
}
