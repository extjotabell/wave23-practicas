package com.deportista.ejercicio.controller;

import com.deportista.ejercicio.dto.SportDTO;
import com.deportista.ejercicio.dto.UserSportDTO;
import com.deportista.ejercicio.entities.Sport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SportController {
    ArrayList<Sport> sports = new ArrayList<>();
    ArrayList<UserSportDTO> userSportDTO = new ArrayList<>();

    Sport football = new Sport("Football", "Pro");
    Sport handball = new Sport("Handball", "Semi pro");
    Sport tennis = new Sport("Tennis", "Semi pro");
    Sport golf = new Sport("Golf", "Pro");

    UserSportDTO ana = new UserSportDTO("Ana", "Lopez", "Tennis");
    UserSportDTO jose = new UserSportDTO("Jose", "Perez", "Football");
    UserSportDTO sofia = new UserSportDTO("Sofia", "Gonzalez", "Golf");

    public SportController() {
        sports.add(football);
        sports.add(handball);
        sports.add(tennis);
        sports.add(golf);
        userSportDTO.add(ana);
        userSportDTO.add(sofia);
    }

    @GetMapping(path = "/findSports")
    ResponseEntity<List<SportDTO>> findSports() {
        List<SportDTO> sportsDTO = new ArrayList<>();
        for (Sport s : sports) {
            SportDTO sportDTO = new SportDTO();
            sportDTO.setName(s.getName());
            sportDTO.setSportLevel(s.getLevel());
            sportsDTO.add(sportDTO);
        }

        return ResponseEntity.ok(sportsDTO);
    }

    @GetMapping(path = "/findSport/{name}")
    ResponseEntity<SportDTO> findSport(@PathVariable String name){
        SportDTO sportDTO = new SportDTO();
        sportDTO.setName(name);
        sportDTO.setSportLevel(this.getSportLevelByName(name).orElse("Level not found"));

        return ResponseEntity.ok(sportDTO);
    }

    @GetMapping(path = "/findSportsPersons")
    ResponseEntity <List<UserSportDTO>> findSportsPersons(){
        return ResponseEntity.ok(userSportDTO);
    }

    private Optional<String> getSportLevelByName(String name) {
        return sports.stream()
                .filter(s -> s.getName().equals(name))
                .map(Sport::getLevel)
                .findFirst();
    }
}
