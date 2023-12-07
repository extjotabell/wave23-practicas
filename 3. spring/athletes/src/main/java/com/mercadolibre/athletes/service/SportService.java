package com.mercadolibre.athletes.service;

import com.mercadolibre.athletes.entity.Sport;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * The SportService class provides functionality related to sports in the athletes application.
 * It manages a list of pre-defined sports and allows retrieving the list or finding a sport by name.
 */
public class SportService {
    private static final List<Sport> sports = initializeSports();

    /**
     * Initializes a list of pre-defined sports with their respective details.
     *
     * @return List of Sport objects.
     */
    private static List<Sport> initializeSports() {
        List<Sport> sports = new ArrayList<>();
        sports.add(new Sport(1, "Pole Sport", 3));
        sports.add(new Sport(2, "Futbol", 2));
        sports.add(new Sport(3, "Handball", 2));
        sports.add(new Sport(4, "Rugby", 2));
        sports.add(new Sport(5, "Basket", 2));
        return sports;
    }

    /**
     * Retrieves the list of pre-defined sports.
     *
     * @return List of Sport objects.
     */
    public List<Sport> getSports() {
        return sports;
    }

    /**
     * Finds a sport by its name, ignoring case.
     *
     * @param name The name of the sport to find.
     * @return Optional containing the Sport object if found, otherwise empty.
     */
    public Optional<Sport> findSportByName(String name) {
        return sports.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}