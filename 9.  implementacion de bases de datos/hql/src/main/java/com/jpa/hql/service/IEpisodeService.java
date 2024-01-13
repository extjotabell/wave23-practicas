package com.jpa.hql.service;

import com.jpa.hql.model.dto.EpisodeDTO;

import java.util.Set;

public interface IEpisodeService {
    Set<EpisodeDTO> getEpisodesByFirstAndLastNameAutor(String firstName, String lastName);
}
