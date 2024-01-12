package com.ospina.hql.servicio.Actor;

import com.ospina.hql.modelo.entidad.Actor;

import java.math.BigDecimal;
import java.util.List;

public interface ActorServicio {

    List<Actor> encontrarActoresConPeliculaFavorita();

    List<Actor> encontrarActoresConRatingSuperiorA(BigDecimal rating);

    List<Actor> encontrarActoresPorPelicula(Integer idPelicula);
}
