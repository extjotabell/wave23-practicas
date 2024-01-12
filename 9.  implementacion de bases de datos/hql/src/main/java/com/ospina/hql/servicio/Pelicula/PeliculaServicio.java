package com.ospina.hql.servicio.pelicula;

import com.ospina.hql.modelo.dto.PeliculaDto;

import java.math.BigDecimal;
import java.util.List;

public interface PeliculaServicio {

    List<PeliculaDto> encontrarPeliculasPorRatingActores(BigDecimal rating);

    List<PeliculaDto> encontrarPeliculasPorGenero(Integer genreId);
}
