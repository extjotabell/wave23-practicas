package com.ospina.hql.servicio.Actor;

import com.ospina.hql.modelo.entidad.Actor;
import com.ospina.hql.repositorio.ActorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorServicioImpl implements ActorServicio {

    private final ActorRepositorio actorRepositorio;

    public ActorServicioImpl(ActorRepositorio actorRepositorio) {
        this.actorRepositorio = actorRepositorio;
    }

    @Override
    @Transactional
    public List<Actor> encontrarActoresConPeliculaFavorita() {
        return actorRepositorio.encontrarActoresConPeliculaFavorita();
    }

    @Override
    @Transactional
    public List<Actor> encontrarActoresConRatingSuperiorA(BigDecimal rating) {
        return actorRepositorio.encontrarActoresConRatingSuperiorA(rating);
    }

    @Override
    @Transactional
    public List<Actor> encontrarActoresPorPelicula(Integer idPelicula) {
        return actorRepositorio.encontrarActoresPorPelicula(idPelicula);
    }
}
