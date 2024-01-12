package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.hql.dto.EpisodeDTO;
import com.mercadolibre.hql.repository.EpisodeRepository;
import com.mercadolibre.hql.utils.EpisodeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {

    EpisodeRepository episodeRepository;
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDTO> findAllByActorLastName(String lastName) {
        return episodeRepository.findAllByActorLastName(lastName).stream()
                .map(EpisodeMapper::episodeMap)
                .toList();
    }
}
