package com.meli.movies.service.actor;

import com.meli.movies.dto.ActorDTO;
import com.meli.movies.dto.ActorsDTO;
import com.meli.movies.repository.IActorRepository;
import com.meli.movies.util.ActorMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    private final IActorRepository repository;

    public ActorServiceImpl(IActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActorsDTO findByFavoriteMovieNotNull() {
        List<ActorDTO> actors = repository.findByFavoriteMovieNotNull().stream()
                .map(ActorMapper::map)
                .toList();
        return new ActorsDTO(actors);
    }

    @Override
    public ActorsDTO findByRatingGreaterThan(BigDecimal rating) {
        List<ActorDTO> actors = repository.findByRatingGreaterThan(rating).stream()
                .map(ActorMapper::map)
                .toList();
        return new ActorsDTO(actors);
    }
}
