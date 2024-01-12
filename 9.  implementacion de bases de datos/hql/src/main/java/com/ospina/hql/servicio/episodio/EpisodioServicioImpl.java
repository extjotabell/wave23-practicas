package com.ospina.hql.servicio.episodio;

import com.ospina.hql.modelo.dto.EpisodeDto;
import com.ospina.hql.repositorio.EpisodioRepositorio;
import com.ospina.hql.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioServicioImpl implements EpisodioServicio{

    private final EpisodioRepositorio episodioRepositorio;

    public EpisodioServicioImpl(EpisodioRepositorio episodioRepositorio) {
        this.episodioRepositorio = episodioRepositorio;
    }

    @Override
    public List<EpisodeDto> encontrarEpisodiosPorActor(String actorName) {
        return DTOMapper.toEpisodeDtoList(episodioRepositorio.encontrarEpisodiosPorActor(actorName));
    }
}
