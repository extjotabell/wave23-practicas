package com.ospina.hql.servicio.pelicula;

import com.ospina.hql.modelo.dto.PeliculaDto;
import com.ospina.hql.repositorio.PeliculaRepositorio;
import com.ospina.hql.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PeliculaServicioImpl implements PeliculaServicio {

    private final PeliculaRepositorio peliculaRepositorio;

    public PeliculaServicioImpl(PeliculaRepositorio peliculaRepositorio) {
        this.peliculaRepositorio = peliculaRepositorio;
    }

    @Override
    public List<PeliculaDto> encontrarPeliculasPorRatingActores(BigDecimal rating) {
        return DTOMapper.toPeliculaDtoList(peliculaRepositorio.encontrarPeliculasPorRatingActores(rating));
    }

    @Override
    public List<PeliculaDto> encontrarPeliculasPorGenero(Integer genreId) {
        return DTOMapper.toPeliculaDtoList(peliculaRepositorio.encontrarPeliculasPorGenero(genreId));
    }
}
