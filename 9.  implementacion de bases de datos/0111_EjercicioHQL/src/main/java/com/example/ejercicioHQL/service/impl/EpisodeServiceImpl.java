package com.example.ejercicioHQL.service.impl;

import com.example.ejercicioHQL.dto.EpisodeDto;
import com.example.ejercicioHQL.mappers.EpisodeMapper;
import com.example.ejercicioHQL.repository.EpisodeRepository;
import com.example.ejercicioHQL.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    @Autowired
    EpisodeRepository episodeRepository;

    @Override
    public List<EpisodeDto> findByActorsMatches(String firstName, String lastName) {
        EpisodeMapper episodeMapper = new EpisodeMapper();
        return episodeRepository.findByActorsMatches(firstName, lastName)
                .stream()
                .map(episodeMapper::mapToEpisodeDto)
                .toList();
    }
}
