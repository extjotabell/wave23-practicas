package com.ospina.hql.servicio.Pelicula;

import com.ospina.hql.modelo.entidad.Pelicula;
import com.ospina.hql.repositorio.PeliculaRepositorio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PeliculaServicioImpl implements PeliculaServicio{

    private final PeliculaRepositorio peliculaRepositorio;

    public PeliculaServicioImpl(PeliculaRepositorio peliculaRepositorio) {
        this.peliculaRepositorio = peliculaRepositorio;
    }

    @Override
    public List<Pelicula> encontrarPeliculasPorRatingActores(BigDecimal rating) {
        return peliculaRepositorio.encontrarPeliculasPorRatingActores(rating);
    }

    @Override
    public List<Pelicula> encontrarPeliculasPorGenero(Integer genreId) {
        return peliculaRepositorio.encontrarPeliculasPorGenero(genreId);
    }
}
