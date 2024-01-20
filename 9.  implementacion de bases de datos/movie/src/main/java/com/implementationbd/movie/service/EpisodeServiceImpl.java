package com.implementationbd.movie.service;

import com.implementationbd.movie.model.dto.EpisodeDto;
import com.implementationbd.movie.repository.IEpisodeRepository;
import com.implementationbd.movie.service.interfaces.IEpisodeService;
import com.implementationbd.movie.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    @Autowired
    IEpisodeRepository repository;

    @Override
    public List<EpisodeDto> getAllEpisodesWithActor(Long actorId) {
        return repository.getAllEpisodesWithActor(actorId)
                .stream()
                .map(UtilConvert::toDto)
                .toList();
    }
}
