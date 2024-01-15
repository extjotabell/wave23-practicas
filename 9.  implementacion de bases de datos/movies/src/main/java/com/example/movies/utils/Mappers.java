package com.example.movies.utils;

import com.example.movies.dto.ActorDto;
import com.example.movies.dto.ActorsListDto;
import com.example.movies.model.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class Mappers {
    private static final ObjectMapper mapper = new ObjectMapper() .registerModule(new JavaTimeModule());

    public static ActorsListDto actorsListToActorsListDto(List<Actor> actors){
        List<ActorDto> actorsList = actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDto.class))
                .toList();
        return new ActorsListDto(actorsList);
    }

}
