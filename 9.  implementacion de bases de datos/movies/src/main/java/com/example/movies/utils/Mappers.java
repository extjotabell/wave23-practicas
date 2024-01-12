package com.example.movies.utils;

import com.example.movies.dto.ActorDto;
import com.example.movies.dto.ActorsListDto;
import com.example.movies.model.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Mappers {
    static ObjectMapper mapper = new ObjectMapper();

    public static ActorsListDto actorsListToActorsListDto(List<Actor> actors){
        List<ActorDto> actorsList = actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDto.class))
                .toList();
        return new ActorsListDto(actorsList);
    }

}
