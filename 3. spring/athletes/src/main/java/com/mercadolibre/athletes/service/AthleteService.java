package com.mercadolibre.athletes.service;

import com.mercadolibre.athletes.entity.Athlete;
import com.mercadolibre.athletes.entity.Sport;

import java.util.ArrayList;
import java.util.List;

/**
 * The AthleteService class provides functionality related to athletes in the sports application.
 * It manages a list of athletes with associated sports.
 */

public class AthleteService {

    // Pre-defined sports
    private static final Sport sport1 = new Sport(1, "Pole Sport", 3);
    private static final Sport sport2 = new Sport(2, "Futbol", 2);
    private static final Sport sport3 = new Sport(3, "Handball", 2);
    private static final Sport sport4 = new Sport(4, "Rugby", 2);
    private static final Sport sport5 = new Sport(5, "Basket", 2);
    private static final List<Athlete> athletes = initializeAthletes();

    /**
     * Initializes a list of athletes with pre-defined data.
     *
     * @return List of Athlete objects.
     */
    private static List<Athlete> initializeAthletes() {
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete("José", "González", 25, sport3));
        athletes.add(new Athlete("Tamara", "González", 30, sport2));
        athletes.add(new Athlete("Arami", "Aquino", 25, sport1));
        athletes.add(new Athlete("Carlos", "Marín", 25, sport4));
        athletes.add(new Athlete("Tomás", "González", 25, sport5));
        return athletes;
    }

    /**
     * Retrieves the list of athletes.
     *
     * @return List of Athlete objects.
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }
}