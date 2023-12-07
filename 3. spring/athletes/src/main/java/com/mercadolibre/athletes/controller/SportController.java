package com.mercadolibre.athletes.controller;

import com.mercadolibre.athletes.mapper.SportMapper;
import com.mercadolibre.athletes.dto.AthleteDTO;
import com.mercadolibre.athletes.dto.SportDTO;
import com.mercadolibre.athletes.entity.Athlete;
import com.mercadolibre.athletes.entity.Sport;
import com.mercadolibre.athletes.service.AthleteService;
import com.mercadolibre.athletes.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for managing sports-related operations.
 */
@RestController
@RequestMapping("/api/sports")
public class SportController {

    private final SportService sportService;
    private final AthleteService athleteService;
    private final SportMapper sportMapper;

    /**
     * Constructor for SportController.
     */
    public SportController() {
        this.sportService = new SportService();
        this.athleteService = new AthleteService();
        this.sportMapper = new SportMapper();
    }

    /**
     * Get endpoint to retrieve a list of all sports.
     *
     * @return ResponseEntity containing a list of SportDTOs.
     */
    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findSports() {
        List<Sport> sports = sportService.getSports();

        List<SportDTO> sportDTOs = sports.stream()
                .map(sportMapper::mapSportToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(sportDTOs);
    }

    /**
     * Get endpoint to retrieve information about a sport by its name.
     *
     * @param name The name of the sport to search for.
     * @return ResponseEntity containing a SportDTO if found, or not found if the sport doesn't exist.
     */
    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        return sportService.findSportByName(name)
                .map(sportMapper::mapSportToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get endpoint to retrieve a list of athletes and their associated sports.
     *
     * @return ResponseEntity containing a list of AthleteDTOs.
     */
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDTO>> findSportsPersons() {
        List<Athlete> athletes = athleteService.getAthletes();

        List<AthleteDTO> dtos = athletes.stream()
                .map(sportMapper::mapPersonToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}