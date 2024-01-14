package com.meli.movies.service.actor;

import com.meli.movies.dto.ActorDTO;
import com.meli.movies.dto.ActorsDTO;
import com.meli.movies.repository.IActorRepository;
import com.meli.movies.util.ActorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    private final IActorRepository repository;

    public ActorServiceImpl(IActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActorsDTO getActorWithFavoriteMovies() {
        List<ActorDTO> actors = repository.findAllActorsWithFavoriteMovie().stream()
                .map(ActorMapper::map)
                .toList();
        return new ActorsDTO(actors);
    }
}
