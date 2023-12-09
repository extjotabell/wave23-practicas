package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.entities.Person;
import com.ejercicio.deportistas.dto.response.PersonSportDto;
import com.ejercicio.deportistas.entities.Sport;
import com.ejercicio.deportistas.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/club/")
public class ClubController {

    @Autowired
    ClubService clubService;
    Map<Sport, Person> personsSports = new HashMap<>();
    Set<Person> persons = new HashSet<>();
    Set<Sport> sports = new HashSet<>();

    @Bean
    private void addInformation() {
        sports.add(new Sport("Futbol", "Alto"));
        sports.add(new Sport("Voley", "Medio"));
        sports.add(new Sport("Natacion", "Bajo"));

        persons.add(new Person("Tomi", "Vazquez", 22));

        personsSports.put(new Sport("Futbol", "Alto"), new Person("Tomi", "Vazquez", 22));
    }

    //Ver todos los deportes que tenemos cargados.
    //PATH: /findSports
    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    //Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
    //PATH: /findSport/{name}
    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        Sport deporte = sports.stream().filter(sport -> sport.getLevel().equals(name)).findFirst().orElse(null);
        if (deporte == null) {
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deporte.getLevel(), HttpStatus.OK);
    }

    //Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para este punto es importante valerse de un DTO.
    //PATH: /findSportsPersons
    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findPersonsSport() {
        List<PersonSportDto> personasDeportistas = new ArrayList<>();
        personsSports.forEach((sport, person) -> {
            PersonSportDto aux = new PersonSportDto((person.getName() + " " + person.getSurname()), sport.getName());
            personasDeportistas.add(aux);
        });
        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }
}
