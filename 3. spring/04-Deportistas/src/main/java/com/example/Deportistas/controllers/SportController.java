package com.example.Deportistas.controllers;

import com.spring.DTO.DTOs.PersonSportDTO;
import com.spring.DTO.DTOs.ResponseDTO;
import com.spring.DTO.entities.Person;
import com.spring.DTO.entities.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SportController {

    private static final List<Sport> SPORTS = new ArrayList<>();
    private static final List<Person> PERSONAS = new ArrayList<>();

    private static final Map<Person, List<Sport>> PERSONAS_DEPORTES = new HashMap<>();

    static {
        SPORTS.add(new Sport("Fútbol", 2));
        SPORTS.add(new Sport("Tenis", 2));
        SPORTS.add(new Sport("Rugby", 3));
        SPORTS.add(new Sport("Basquet", 1));
        SPORTS.add(new Sport("Equitación", 3));
        SPORTS.add(new Sport("Hockey", 3));
        SPORTS.add(new Sport("Natación", 2));
        PERSONAS.add(new Person("Ailen", "Pereira", 28));
        PERSONAS.add(new Person("Juan", "Perez", 20));
        PERSONAS.add(new Person("Carlos", "Martinez", 65));
        PERSONAS_DEPORTES.put(PERSONAS.get(0), SPORTS.subList(0,1));
        PERSONAS_DEPORTES.put(PERSONAS.get(1), SPORTS.subList(1,4));
        PERSONAS_DEPORTES.put(PERSONAS.get(2), SPORTS.subList(2,5));
    }


    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports(){
        return new ResponseEntity<>(SPORTS, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<ResponseDTO> findSportByName(@PathVariable String name){
        Sport sportFound = null;
        for (Sport sport : SPORTS) {
            if(sport.getNombre().equalsIgnoreCase(name)){
                sportFound = sport;
            }
        };
        if(sportFound == null){
            return ResponseEntity.badRequest().body(new ResponseDTO("Deporte no encontrado"));
        }
        return ResponseEntity.ok(new ResponseDTO("El deporte " + sportFound.getNombre() + " tiene un nivel:" + sportFound.getNivel()));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        List<PersonSportDTO> personSportList = PERSONAS_DEPORTES.entrySet().stream()
                .map(entry -> new PersonSportDTO(entry.getKey().getNombre(), entry.getKey().getApellido(), entry.getValue().stream().map(sport -> sport.getNombre()).toList()))
                .toList();
        if(personSportList.isEmpty()){
            return ResponseEntity.badRequest().body("No se encontraron personas que practiquen deportes");
        }
        return ResponseEntity.ok(personSportList);
    }
}
