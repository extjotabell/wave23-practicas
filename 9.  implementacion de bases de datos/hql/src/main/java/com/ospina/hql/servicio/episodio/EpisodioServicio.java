package com.ospina.hql.servicio.episodio;

import com.ospina.hql.modelo.dto.EpisodeDto;

import java.util.List;

public interface EpisodioServicio {

    List<EpisodeDto> encontrarEpisodiosPorActor(String actorName);
}
