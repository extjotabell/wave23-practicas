package com.bootcamp.sportsapi.service;

import com.bootcamp.sportsapi.dto.SportDTO;
import com.bootcamp.sportsapi.model.Sport;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class SportService {
    private List<Sport> sports = new ArrayList<>();


    public List<SportDTO> getSports() {
        if (sports.isEmpty()) this.loadSports();
        return sports.stream().map(s -> new SportDTO(s.getName(), s.getLevel())).toList();
    }

    public Optional<SportDTO> findByName(String name){
        if (sports.isEmpty()) this.loadSports();
        return sports.stream().filter(s -> s.getName().equals(name))
                .map( s -> new SportDTO(s.getName(), s.getLevel())).findFirst();
    }

    private void loadSports() {
        Sport football = new Sport("Football", "Beginner");
        Sport basket = new Sport("Basket", "Beginner");
        Sport tennis = new Sport("Tennis", "Professional");
        sports.addAll(List.of(football, basket, tennis));
    }

}
