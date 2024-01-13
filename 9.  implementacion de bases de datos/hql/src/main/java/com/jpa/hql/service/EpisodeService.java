package com.jpa.hql.service;

import com.jpa.hql.model.dto.EpisodeDTO;
import com.jpa.hql.repository.IEpisodeRepository;
import com.jpa.hql.utils.IMappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService{
    @Autowired
    IEpisodeRepository episodeRepository;
    @Autowired
    IMappingUtility mappingUtility;
    @Override
    public Set<EpisodeDTO> getEpisodesByFirstAndLastNameAutor(String firstName, String lastName) {
        return episodeRepository.findByActorNameEquals(firstName, lastName).stream()
                .map(eE -> mappingUtility.episodeEntityToDTO(eE))
                .collect(Collectors.toSet());
    }
}
