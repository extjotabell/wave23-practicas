package com.example.ejercicioHQL.service;

import com.example.ejercicioHQL.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {

    public List<EpisodeDto> findByActorsMatches(String firstName, String lastName);

}
