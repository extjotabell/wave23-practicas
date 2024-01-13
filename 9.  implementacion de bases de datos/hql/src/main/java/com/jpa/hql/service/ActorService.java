package com.jpa.hql.service;

import com.jpa.hql.model.dto.ActorDTO;
import com.jpa.hql.model.entity.ActorEntity;
import com.jpa.hql.repository.IActorRepository;
import com.jpa.hql.utils.IMappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{
    @Autowired
    IActorRepository actorRepository;
    @Autowired
    IMappingUtility mappingUtility;

    public Set<ActorDTO> getAllActorsWithFavoriteMovie() {
        Set<ActorEntity> actorEntities = actorRepository.findAllWithFavoriteMovie();
        return actorEntities.stream()
                .map(aE -> mappingUtility.actorEntityToDTO(aE))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ActorDTO> getAllActorsWithRatingGraterThan(BigDecimal rating) {
        Set<ActorEntity> actorEntities = actorRepository.findByRatingGreaterThan(rating);
        return actorEntities.stream()
                .map(aE -> mappingUtility.actorEntityToDTO(aE))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ActorDTO> getAllActorsWhoParticipatedInMovie(String movieName){
        Set<ActorEntity> actorEntities = actorRepository.findByMovie(movieName);
        return actorEntities.stream()
                .map(aE -> mappingUtility.actorEntityToDTO(aE))
                .collect(Collectors.toSet());
    }

}
