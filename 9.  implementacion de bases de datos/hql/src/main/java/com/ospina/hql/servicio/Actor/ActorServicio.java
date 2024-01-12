package com.ospina.hql.servicio.actor;

import com.ospina.hql.modelo.dto.ActorDto;
import com.ospina.hql.modelo.entidad.Actor;

import java.math.BigDecimal;
import java.util.List;

public interface ActorServicio {

    List<ActorDto> encontrarActoresConPeliculaFavorita();

    List<ActorDto> encontrarActoresConRatingSuperiorA(BigDecimal rating);

    List<ActorDto> encontrarActoresPorPelicula(String tituloPelicula);
}
