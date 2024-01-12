package com.ospina.hql.servicio.Pelicula;

import com.ospina.hql.modelo.entidad.Pelicula;

import java.math.BigDecimal;
import java.util.List;

public interface PeliculaServicio {

    List<Pelicula> encontrarPeliculasPorRatingActores(BigDecimal rating);

    List<Pelicula> encontrarPeliculasPorGenero(Integer genreId);
}
