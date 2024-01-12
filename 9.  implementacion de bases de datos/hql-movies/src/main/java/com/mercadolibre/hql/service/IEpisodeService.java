package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.EpisodeDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDTO> findAllByActorLastName(String lastName);
}
