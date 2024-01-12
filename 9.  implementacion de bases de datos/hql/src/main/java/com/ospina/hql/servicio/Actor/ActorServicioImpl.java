package com.ospina.hql.servicio.actor;

import com.ospina.hql.modelo.dto.ActorDto;
import com.ospina.hql.repositorio.ActorRepositorio;
import com.ospina.hql.util.DTOMapper;
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
    public List<ActorDto> encontrarActoresConPeliculaFavorita() {
        return DTOMapper.toActorDtoList(actorRepositorio.encontrarActoresConPeliculaFavorita());
    }

    @Override
    @Transactional
    public List<ActorDto> encontrarActoresConRatingSuperiorA(BigDecimal rating) {
        return DTOMapper.toActorDtoList(actorRepositorio.encontrarActoresConRatingSuperiorA(rating));
    }

    @Override
    @Transactional
    public List<ActorDto> encontrarActoresPorPelicula(String tituloPelicula) {
        return DTOMapper.toActorDtoList(actorRepositorio.encontrarActoresPorPelicula(tituloPelicula));
    }
}
